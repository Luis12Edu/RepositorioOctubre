function eliminar(id){
	swal({
  title: "¿Realmente desea eliminar registro?",
  text: "Si elimina el registro no podra recuperarlo",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((Ok) => {
  if (Ok) {
	$.ajax({
		url:"/eliminar/" + id,
		succecc:function(res){
			console.log(res);
		},
	});
    swal("Elimino el registro correctamente", {
      icon: "success",
    }).then((ok) =>{
		if(ok){
		location.href="/listar";
		}
	});
  } else {
    swal("No se guardo ningun cambio");
  }
});
}