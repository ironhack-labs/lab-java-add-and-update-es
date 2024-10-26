### Escribir una respuesta corta en README.md. En su README.md escriba una respuesta corta a las siguientes preguntas:

¿Usó el mismo tipo de ruta para actualizar la información del paciente y para actualizar un departamento de empleados?
No. Utilice una ruta independiente para cada consulta o actualización.


¿Por qué eligió la estrategia que eligió?
Elegí la estrategia de buscar siempre por ID, ya que ID es un identificador único por el cual el usuaria solo encontrara
uno, y realice una ruta independiente por si el usuario no envía toda la información del formulario
solo si encuentra el ID puede actualizar el dato.


¿Cuáles son las ventajas e inconvenientes de las estrategias que eligió para crear estas rutas?
La ventaja es que siempre va poder encontrar por el ID si este está en la base de datos
pero los inconvenientes serán actualizar los datos con cualquier información que quiera el usuario


¿Cuáles son los compromisos entre PUT y PATCH?
PUT se utiliza para la actualizaciones completas que el usuario quiera enviar, por ejemplo: el usuario puede actualizar
nombre, apellido, correo, tlf y cualquier atributo que le esté enviando. En cambio PATCH se utiliza para las actualizaciones parciales. Solo se actualizará 1 solo atributo que se le envíe.
