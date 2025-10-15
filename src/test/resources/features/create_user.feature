Feature: Crear un usuario
  Como administrador
  Quiero poder crear un usuario
  Para que quede registrado en el sistema

  Scenario: Crear un usuario nuevo correctamente como administrador
    Given no existe un usuario
    When creo un usuario
    Then el usuario debe existir en la base de datos