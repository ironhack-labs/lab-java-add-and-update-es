
- **�Us� el mismo tipo de ruta para actualizar la informaci�n del paciente y para actualizar un departamento de empleados?**
  No. Us� `PUT` para actualizar toda la informaci�n del paciente y `PATCH` para actualizar solo el departamento de un empleado.

- **�Por qu� eligi� la estrategia que eligi�?**
  Eleg� `PUT` para actualizar al paciente porque este m�todo es adecuado cuando se reemplaza todo el recurso, y `PATCH` para actualizaciones parciales, como cambiar solo el estado o departamento del empleado.

- **�Cu�les son las ventajas e inconvenientes de las estrategias que eligi� para crear estas rutas?**
  La combinaci�n de `PUT` y `PATCH` permite claridad en las operaciones: `PUT` indica reemplazo total, mientras que `PATCH` expresa cambios parciales. Sin embargo, puede ser confuso para los usuarios, ya que tienen que saber qu� m�todo corresponde a cada tipo de actualizaci�n.

- **�Cu�les son los compromisos entre `PUT` y `PATCH`?**
  `PUT` es idempotente y asegura que todos los campos del recurso se actualicen, pero puede requerir m�s datos. `PATCH` permite actualizaciones parciales y es m�s eficiente, pero puede introducir ambig�edad si el manejo de datos parciales no es claro.
