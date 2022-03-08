(function () {
    document.addEventListener('DOMContentLoaded', function () {
        document.getElementById("getit").addEventListener("click", function () {
            fetch("JsonServlet", {
                headers: {
                    'Content-Type': 'application/json'
                }})
                .then(res => res.json())
                .then(resp => {
                    res = "<p>name: " + resp.name + "</p><p>value: " + resp.value;

                    document.getElementById("data").innerHTML = res;
                })
                .catch(e => {
                    document.getElementById("data").innerHTML = "Some error occured!";
                });
        });
    });
})();