let auto = [
    { rok: 2018, przebieg: 120000, cena_wyjsciowa: 25000, cena_koncowa: 22000 },
    { rok: 2019, przebieg: 100000, cena_wyjsciowa: 30000, cena_koncowa: 28000 },
    { rok: 2020, przebieg: 50000, cena_wyjsciowa: 40000, cena_koncowa: 32000 },
    { rok: 2021, przebieg: 20000, cena_wyjsciowa: 45000, cena_koncowa: 42000 },
    { rok: 2022, przebieg: 15000, cena_wyjsciowa: 50000, cena_koncowa: 48000 },
    { rok: 2023, przebieg: 10000, cena_wyjsciowa: 60000, cena_koncowa: 52000 }]

function createTable(data) {
    var table = document.createElement('table');
    var thead = document.createElement('thead');
    var tbody = document.createElement('tbody');
    var headers = ['Rok', 'Przebieg', 'Cena wyjściowa', 'Cena końcowa'];
    var headerRow = document.createElement('tr');
    headers.forEach(function(header) {
        var th = document.createElement('th');
        th.textContent = header;
        headerRow.appendChild(th);
    });

    thead.appendChild(headerRow);
    data.forEach(function(car) {
        var row = document.createElement('tr');
        Object.values(car).forEach(function(value) {
            var td = document.createElement('td');
            td.textContent = value;
            row.appendChild(td);
        });
        tbody.appendChild(row);
    });

    table.appendChild(thead);
    table.appendChild(tbody);
    return table;
}

function showTable() {
    var tableContainer = document.getElementById('table-container');
    tableContainer.innerHTML = '';
    tableContainer.appendChild(createTable(auto));
}

var showTableBtn = document.getElementById('show-table-btn');
showTableBtn.addEventListener('click', showTable);