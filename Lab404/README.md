¿Usó el mismo tipo de ruta para actualizar la información del paciente y para actualizar un departamento de empleados?

No, la ruta para actualizar la información del paciente es: http://localhost:8080/patients/id y luego generamos un json con la información a actualizar
mientras que para actualizar el departamento de un empleado sería: http://localhost:8080/employees/id/department y ponemos el param department que se desea actualizar en la ruta.

¿Por qué eligió la estrategia que eligió?

Me pareció correcta y funcionaba.

¿Cuáles son las ventajas e inconvenientes de las estrategias que eligió para crear estas rutas?

El código es claro y facil de entender

¿Cuáles son los compromisos entre PUT y PATCH?

Se utilizan ara actualizaciones completas o parciales, respectivamente.