document.getElementById("1").addEventListener("click", function () {
    var radio = document.getElementById("input1");
    radio.checked = !radio.checked;

    if (radio.checked === true) {
        this.style.backgroundColor = "#00C985";
    } else {
        this.style.backgroundColor = "#CAD2DC";
    }
});
document.getElementById("2").addEventListener("click", function () {
    var radio = document.getElementById("input2");
    radio.checked = !radio.checked;

    if (radio.checked === true) {
        this.style.backgroundColor = "#00C985";
    } else {
        this.style.backgroundColor = "#CAD2DC";
    }
});

document.getElementById("3").addEventListener("click", function () {
    var radio = document.getElementById("input3");
    radio.checked = !radio.checked;

    if (radio.checked === true) {
        this.style.backgroundColor = "#00C985";
    } else {
        this.style.backgroundColor = "#CAD2DC";
    }
});

document
    .getElementsByClassName("save_btn")[0]
    .addEventListener("click", function () {
        alert("Create Successfully !");
        window.location.reload();
    });
