Osinergmin.event.onDOMReady(function() {
    var layout = new YAHOO.widget.Layout({
        units: [
            { position: 'top', body: 'layout-top', height: 61 },
            { position: 'right', body: 'layout-right', header: 'Ayuda', width: 300, resize: false, gutter: '5px', collapse: true, scroll: true, animate: true },
            { position: 'left', body: 'layout-left', width: 140, resize: true, gutter: '5px' },
            { position: 'center', body: 'layout-center',gutter: '5px 0px' }
        ]
    });

    layout.on('render', function() {
        var el = layout.getUnitByPosition('center').get('wrap');
        var layout2 = new YAHOO.widget.Layout(el, {
            parent: layout,
            minWidth: 400,
            minHeight: 200,
            units: [
                { position: 'top', body: 'layout-center-top', height: 600, gutter: '0px',resize: true },
                { position: 'center', body: 'layout-center-bottom', gutter: '0px', scroll: true }
            ]
        });
        layout2.render();
    });
    layout.render();

});