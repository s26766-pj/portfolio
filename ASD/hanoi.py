def hanoi(n, source, target, auxiliary, towers, move_count):
    if n == 1:
        move_count = move_disk(towers, source, target, move_count)
        return move_count
    move_count = hanoi(n - 1, source, auxiliary, target, towers, move_count)
    move_count = move_disk(towers, source, target, move_count)
    move_count = hanoi(n - 1, auxiliary, target, source, towers, move_count)
    return move_count

def print_towers(towers):
    for i, tower in enumerate(towers):
        tower_name = chr(65 + i)  # Convert 0 -> A, 1 -> B, 2 -> C
        print(f"Tower {tower_name}: {tower}")

def move_disk(towers, source, target, move_count):
    # Check if source tower is empty
    if not towers[source]:
        print(f"Illegal move: No disk to move on tower {chr(65 + source)}")
        return move_count

    # Check if move is legal
    if towers[target] and towers[source][-1] > towers[target][-1]:
        print(f"Illegal move: Cannot place disk {towers[source][-1]} on top of disk {towers[target][-1]}")
        return move_count

    disk = towers[source].pop()
    towers[target].append(disk)
    source_name = chr(65 + source)
    target_name = chr(65 + target)
    print(f"Move {move_count}: Move disk {disk} from tower {source_name} to tower {target_name}")
    print_towers(towers)
    return move_count + 1

def main():
    # Początkowy stan wież:
    # Na kiju A: dyski 8, 4, 3, 1,
    # Na kiju B: dyski 7, 6, 5,
    # Na kiju C: dysk 2
    towers = [[8, 4, 3, 1], [7, 6, 5], [2]]

    print("Initial state:")
    print_towers(towers)

    # Znajdź rzeczywistą liczbę dysków w początkowym stanie
    total_disks = sum(len(tower) for tower in towers)
    move_count = 1
    hanoi(total_disks, 0, 2, 1, towers, move_count)

    print("Final state:")
    print_towers(towers)

if __name__ == "__main__":
    main()
