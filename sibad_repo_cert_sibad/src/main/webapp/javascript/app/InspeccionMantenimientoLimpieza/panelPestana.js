//Funciones Panel de Pestañas
function tab(pestana,panel)
{
	pst 	= document.getElementById(pestana);
	pnl 	= document.getElementById(panel);
	psts	= document.getElementById('tabs').getElementsByTagName('li');
	pnls	= document.getElementById('paneles').getElementsByTagName('form');
	
	// eliminamos las clases de las pestañas
	for(i=0; i< psts.length; i++)
	{
		psts[i].className = '';
	}
	
	// Añadimos la clase "actual" a la pestaña activa
	pst.className = 'actual';
	
	// eliminamos las clases de las pestañas
	for(i=0; i< pnls.length; i++)
	{
		pnls[i].style.display = 'none';
	}
	
	// Añadimos la clase "actual" a la pestaña activa
	pnl.style.display = 'block';
}