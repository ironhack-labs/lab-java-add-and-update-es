¿Usó el mismo tipo de ruta para actualizar la información del paciente y para actualizar un departamento de empleados?  No. Usé `PUT` para actualizar toda la información del paciente y `PATCH` para actualizar solo el departamento de un empleado.

¿Por qué eligió la estrategia que eligió? Elegí `PUT` para actualizar al paciente porque este método es adecuado cuando se reemplaza todo el recurso, y `PATCH` para actualizaciones parciales, como cambiar solo el estado o departamento del empleado.

¿Cuáles son las ventajas e inconvenientes de las estrategias que eligió para crear estas rutas? La combinación de `PUT` y `PATCH` permite claridad en las operaciones: `PUT` indica reemplazo total, mientras que `PATCH` expresa cambios parciales. Sin embargo, puede ser confuso para los usuarios, ya que tienen que saber qué método corresponde a cada tipo de actualización.

¿Cuáles son los compromisos entre PUT y PATCH? `PUT` es idempotente y asegura que todos los campos del recurso se actualicen, pero puede requerir más datos. `PATCH` permite actualizaciones parciales y es más eficiente, pero puede introducir ambigüedad si el manejo de datos parciales no es claro.