(function () {

    const screenWidth = window.innerWidth;


    const items = [
        'resource/7.png',
        'resource/arbuz.png',
        'resource/banan.png',
        'resource/bar.png',
        'resource/cytryna.png',
        'resource/czeresnia.png',
        'resource/grono.png',
        'resource/pomarancza.png',
        'resource/sliwa.png'
    ];

    const doors = document.querySelectorAll('.door');
    let upperOutput = document.getElementById("rate");
    let lowerOutput = document.getElementById("score");
    let rate = 100;
    let score = 10000;
    let lastItems = ['resource/7.png', 'resource/7.png', 'resource/7.png'];
    document.querySelector('#spinner').addEventListener('click', spin);
    document.querySelector('#reset').addEventListener('click', reset);
    document.querySelector('#plus').addEventListener('click', increase);
    document.querySelector('#minus').addEventListener('click', decrease);

    function increase() {
        let currentRate = rate
        if (currentRate < score) {
            currentRate = Math.min(score, currentRate + 10);
            rate = currentRate;
        } else {
            alert("Stawka nie może być większa niż aktualny fundusz.");
        }
        upperOutput.innerText = 'stawka: ' + rate.toString();
    }

    function decrease() {
        let currentRate = rate;
        if (currentRate > 10) {
            currentRate = Math.max(0, currentRate - 10);
            rate = currentRate;
        } else {

            alert("Stawka nie może być mniejsza niż 10.");
        }
        upperOutput.innerText = 'stawka: ' + currentRate.toString();
    }

    function reset() {
        rate = 100;
        score = 10000;
        document.querySelector('#spinner').disabled = false;
        init();
    }

    function checkScore() {
        score = score - rate;
        upperOutput.innerText = 'stawka: ' + rate.toString();
        lowerOutput.innerText = 'kasa: ' + score.toString();
        if (score <= 0) {
            const endSound = new Audio('resource/end.mp3');
            setTimeout(() => {
                endSound.play();
            }, 1000);
            document.querySelector('#spinner').disabled = true;
        }
    }

    function init(
        firstInit = true,
        groups = 1,
        duration = 1,
        entry = ['resource/7.png', 'resource/7.png', 'resource/7.png']
    ) {

        upperOutput.innerText = 'stawka: ' + rate.toString();
        lowerOutput.innerText = 'kasa: ' + score.toString();
        let loopCounter = 0;
        for (const door of doors) {
            loopCounter++;
            if (firstInit) {
                door.dataset.spinned = '0';
            } else if (door.dataset.spinned === '1') {
                return;
            }
            const boxes = door.querySelector('.boxes');
            const boxesClone = boxes.cloneNode(false);
            const pool = [entry[loopCounter-1]];

            if (!firstInit) {
                const arr = [];
                for (let n = 0; n < (groups > 0 ? groups : 1); n++) {
                    arr.push(...items);
                }
                pool.push(...shuffle(arr, loopCounter));

                boxesClone.addEventListener(
                    'transitionstart',
                    function () {
                        door.dataset.spinned = '2';
                        this.querySelectorAll('.box').forEach((box) => {
                            box.style.filter = 'blur(1px)';
                        });
                    },
                    { once: true }
                );

                boxesClone.addEventListener(
                    'transitionend',
                    function () {
                        this.querySelectorAll('.box').forEach((box, index) => {
                            box.style.filter = 'blur(0)';
                            if (index > 0) this.removeChild(box);
                        });
                    },
                    { once: true }
                );
            }

            for (let i = pool.length - 1; i >= 0; i--) {
                const box = document.createElement('div');
                box.classList.add('box');
                box.style.width = '100%';
                box.style.height = '100%';


                if (pool[i] === '?') {
                    box.textContent = pool[i];
                } else {
                    const img = document.createElement('img');
                    img.src = pool[i];
                    box.appendChild(img);
                }

                boxesClone.appendChild(box);
            }
            boxesClone.style.transitionDuration = `${duration > 0 ? duration : 1}s`;
            boxesClone.style.transform = `translateY(-${door.clientHeight * (pool.length - 1)}px)`;
            door.replaceChild(boxesClone, boxes);
        }
    }

    function shuffle([...arr], loopCounter = 0) {
        let m = arr.length;
        while (m) {
            const i = Math.floor(Math.random() * m--);
            [arr[m], arr[i]] = [arr[i], arr[m]];
        }
        lastItems[loopCounter-1] = arr[8]
        return arr;
    }

    function addToScore(symbol, rate) {
        switch (symbol) {
            case 'resource/7.png':
                score = score + rate * 700;
                break;
            case 'resource/bar.png':
                score = score + rate * 500;
                break;
            case 'resource/grono.png':
                score = score + rate * 300;
                break;
            case 'resource/arbuz.png':
                score = score + rate * 300;
                break;
            case 'resource/banan.png':
                score = score + rate * 200;
                break;
            case 'resource/sliwa.png':
                score = score + rate * 200;
                break;
            case 'resource/cytryna.png':
                score = score + rate * 150;
                break;
            case 'resource/pomarancza.png':
                score = score + rate * 150;
                break;
            case 'resource/wysnia.png':
                score = score + rate * 100;
                break;
            default:
                console.error("Nieobsługiwany symbol:", symbol);
                break;
        }
    }

    function checkForSuccess() {
        const uniqueItems = Array.from(new Set(lastItems));

        for (const item of uniqueItems) {
            const indices = [];

            for (let i = 0; i < lastItems.length; i++) {
                if (lastItems[i] === item) {
                    indices.push(i);
                }
            }

            if (indices.length === 3) {
                setTimeout(() => {
                    const successSound = new Audio('resource/success.mp3');
                    successSound.play();
                    addToScore(item, rate);
                }, 1000);
                return;
            }
        }

    }

    async function spin() {
        init(false, 1, 2, [...lastItems]);

        for (const door of doors) {
            const boxes = door.querySelector('.boxes');
            const duration = parseInt(boxes.style.transitionDuration);
            boxes.style.transform = 'translateY(0)';
            await new Promise((resolve) => setTimeout(resolve, duration * 100));
        }
        checkForSuccess();
        setTimeout(() => {
            checkScore();
        }, 1500);

    }
    init();
})();
