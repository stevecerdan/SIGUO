(function(){var B=YAHOO.Bubbling,D=YAHOO.util.History,C=YAHOO.lang,A=YAHOO.util.Event;YAHOO.plugin.Navigation=function(){var K={},H="q",J={},E=D.getBookmarkedState(H)||"default",L=null,G="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";B.on("newRestorationEntry",function(N,M){if(M[1].state){K.add(M[1].state,M[1]);}});function F(S){var O,Q,M;var R,P,N;M=S.length;Q=0;O="";while(Q<M){R=S.charCodeAt(Q++)&255;if(Q==M){O+=G.charAt(R>>2);O+=G.charAt((R&3)<<4);O+="==";break;}P=S.charCodeAt(Q++);if(Q==M){O+=G.charAt(R>>2);O+=G.charAt(((R&3)<<4)|((P&240)>>4));O+=G.charAt((P&15)<<2);O+="=";break;}N=S.charCodeAt(Q++);O+=G.charAt(R>>2);O+=G.charAt(((R&3)<<4)|((P&240)>>4));O+=G.charAt(((P&15)<<2)|((N&192)>>6));O+=G.charAt(N&63);}return O;}function I(P){var N,O,M,Q;N="";M=P.length;for(O=0;O<M;O++){Q=P.charCodeAt(O);if((Q>=1)&&(Q<=127)){N+=P.charAt(O);}else{if(Q>2047){N+=String.fromCharCode(224|((Q>>12)&15));N+=String.fromCharCode(128|((Q>>6)&63));N+=String.fromCharCode(128|((Q>>0)&63));}else{N+=String.fromCharCode(192|((Q>>6)&31));N+=String.fromCharCode(128|((Q>>0)&63));}}}return N;}K.debug=false;K.init=function(){try{YAHOO.util.History.initialize("yui-history-field","yui-history-iframe");}catch(M){return false;}D.register(H,E,K.restore);B.on("onNavigate",function(O,N){if(N[1].state){K.navigate(N[1].state,N[1]);}});D.onReady(function(){var N=D.getCurrentState(H);K.restore(N);});};K.restore=function(M){if(M&&J.hasOwnProperty(M)&&C.isFunction(J[M].restore)){E=M;if(!J[M].active){if(K.debug){console.log("restore",M);}J[M].restore.call(J[M],M);}J[M].active=false;}};K.navigate=function(O,N){O=F(I(O));var P=this.add(O,N);var M=D.getCurrentState(H);if(O&&(M!=O)){if(K.debug){console.log("Navigate",O);}J[O].active=true;D.navigate(H,O);return true;}return false;};K.add=function(N,M){var O={state:N};if(N&&M){C.augmentObject(O,M);J[N]=O;if(K.debug){console.log("Add",N);}}return O;};K.setDefaultState=function(M){if(C.isFunction(M)){this.add("default",{state:"default",restore:M});L=M;}};K.tabView=function(Q){var O=Q.get("tabs"),N,M,R,P;for(N=0,M=O.length;N<M;N++){R=O[N];P="tabview-"+Q.get("element").id+"-tab-"+N;this.add(P,{state:P,tab:N,restore:function(){oTabView.set("activeIndex",N);}});}Q.addListener("activeTabChange",function(T){var S=this.getTabIndex(T.newValue);YAHOO.plugin.Navigation.navigate("tabview-"+Q.get("element").id+"-tab-"+S,{restore:function(){Q.set("activeIndex",S);},tab:S,tabview:Q});});};A.onDOMReady(K.init,K,true);return K;}();})();YAHOO.register("navigation",YAHOO.plugin.Navigation,{version:"@VERSION@",build:"@BUILD@"});