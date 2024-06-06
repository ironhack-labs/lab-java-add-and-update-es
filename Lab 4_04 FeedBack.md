## Lab 4.04 Add And Update - Semana 10

Your submitted this lab on  June 6th 2024.

Añadir nuevo paciente

¡Excelente trabajo añadiendo la ruta para agregar un nuevo paciente! Tu implementación en la clase  `PatientController`  es clara y correcta. El uso de  `@PostMapping`  y la anotación  `@ResponseStatus(HttpStatus.CREATED)`  están bien aplicados. Aquí tienes un ejemplo real y funcional de cómo agregar un paciente usando el endpoint  `/patients`:

`1 2 3 4 5 6` `POST /patients
{
  "name": "Nuevo Paciente",
  "dateOfBirth": "2000-01-01",
  "admittedBy": 564134
}`

Felicitaciones por el gran trabajo.

Was this feedback useful?

Añadir nuevo doctor

¡Muy bien hecho implementando la ruta para agregar un nuevo doctor! La clase  `EmployeeController`  maneja correctamente la creación de un nuevo doctor con  `@PostMapping`  y  `@ResponseStatus(HttpStatus.CREATED)`. Aquí tienes un ejemplo real y funcional de cómo agregar un doctor usando el endpoint  `/employees`:

`1 2 3 4 5 6 7` `POST /employees
{
  "employeeId": "987654",
  "department": "neurology",
  "name": "Dr. House",
  "status": "ON"
}`

¡Sigue así!

Was this feedback useful?

Cambiar el estado del doctor

Has implementado correctamente la ruta para cambiar el estado de un doctor. El uso de  `@PatchMapping`  y  `@RequestParam`  es adecuado y eficaz. Aquí tienes un ejemplo funcional de cómo cambiar el estado de un doctor usando el endpoint  `/employees/status`:

`1` `PATCH /employees/status?id=987654&status=ON_CALL`

¡Excelente trabajo!

Was this feedback useful?

Actualizar el departamento del doctor

¡Gran trabajo en la implementación de la ruta para actualizar el departamento de un doctor! El uso de  `@PatchMapping`  es correcto y la lógica en el método  `changeDepartment`  de  `EmployeeService`  es clara. Aquí tienes un ejemplo funcional de cómo actualizar el departamento de un doctor usando el endpoint  `/employees/department`:

`1` `PATCH /employees/department?id=987654&department=paediatrics`

¡Buen trabajo!

Was this feedback useful?

Actualizar la información del paciente

Has hecho un excelente trabajo al implementar la ruta para actualizar la información del paciente. El uso de  `@PutMapping`  y la lógica en  `PatientService`  para actualizar el paciente está bien estructurada. Aquí tienes un ejemplo funcional de cómo actualizar la información de un paciente usando el endpoint  `/patients/{id}`:

`1 2 3 4 5 6` `PUT /patients/1
{
  "name": "Jaime Jordan Updated",
  "dateOfBirth": "1984-03-03",
  "admittedBy": 564134
}`

¡Sigue con el buen trabajo!
