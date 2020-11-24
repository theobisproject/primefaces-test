/* Place any Javascript here you want loaded in test.xhtml */
window.addEventListener("beforeunload", function (e) {
    e.preventDefault();
    e.returnValue = 'Show alert message on beforeunload event';
});

window.addEventListener("unload", function (e) {
    loggingCommand();
});
