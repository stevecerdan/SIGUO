/**
 * Para mostrar y ocultar la barra de loading se tiene que hacer uso de las siguientes instrucciones
 * Mostrar: Osinergmin.loading.show();
 * Ocultar: Osinergmin.loading.hide();
 */

Osinergmin.loading = {};

Osinergmin.loading.show = function(){

        if (!Osinergmin.loading.panel) {
            Osinergmin.loading.panel = new YAHOO.widget.Panel("loading-panel",
                                                { width: "240px",
                                                  fixedcenter: true,
                                                  close: false,
                                                  draggable: false,
                                                  zindex:4,
                                                  modal: true,
                                                  visible: false
                                                }
                                            );

            Osinergmin.loading.panel.setHeader("Procesando, espere por favor...");
            Osinergmin.loading.panel.setBody("<img src=\"http://l.yimg.com/a/i/us/per/gr/gp/rel_interstitial_loading.gif\"/>");
            Osinergmin.loading.panel.render(document.body);
        }
        Osinergmin.loading.panel.show();
};

Osinergmin.loading.hide = function(){
    Osinergmin.loading.panel.hide();
};