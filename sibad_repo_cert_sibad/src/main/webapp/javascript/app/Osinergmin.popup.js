Osinergmin.popup = {};
Osinergmin.popup.manager = {};
Osinergmin.popup.manager.show = function(href, title, width, height) {
    if (href == undefined) {
        alert("href no definido.");
    } else {
        if (!Osinergmin.panel) {
        Osinergmin.panel = new YAHOO.widget.Panel("dialog-panel",
                                                { width: width,
                                                  height: height,
                                                  fixedcenter: true,
                                                  close: true,
                                                  draggable: false,
                                                  zindex:4,
                                                  modal: true,
                                                  visible: false
                                                });
       Osinergmin.panel.setHeader(title);
       Osinergmin.panel.setBody('<iframe frameborder="0" src="' + href + '" width="100%" height="100%"/>');
       Osinergmin.panel.render(document.body);
       }
       Osinergmin.panel.show();
    }
};