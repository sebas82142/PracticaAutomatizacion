Feature: Inicio sesion
  Como usuario quiero Iniciar sesion en Guru 99 Bank

#  Scenario Outline: Ingresar a la pagina de obtención de credenciales
#    Given el usuario se registra con correo asd@asd.com
#    And se autentica con credenciales del sistema
#    When  el usuario registra un nuevo cliente con datos
#      | NameCustomer  | Gender 	 | DateOfBirth 	 | Address 	 | City	  | State 	| PhoneNumber   | Email   | Password |
#      | <NameCustomer>| <Gender> | <DateOfBirth> | <Address> | <City> | <State> | <PhoneNumber> | <Email> | <Password> |
#    And el usuario elimina el cliente registrado por su id
#    Then el usuario deberia visualizar el mensaje Customer deleted Successfully
#    
#    Examples: 
#      | NameCustomer| Gender | DateOfBirth | Address 			 | City	 | State  | PhoneNumber  | Email            | Password |
#      | Pedro      	| Male	 | 15/02/1994  | street1st franklin  | Kansas| Kansas | 96211336	 | Petro@kansas.com | asd123	  |
      
      
  Scenario Outline: Ingresar a la pagina de obtención de credenciales
    Given el usuario se registra con correo asd@asd.com
    And se autentica con credenciales del sistema
    And el usuario registra un nuevo cliente con datos
      | NameCustomer  | Gender 	 | DateOfBirth 	 | Address 	 | City	  | State 	| PhoneNumber   | Email   | Password |
      | <NameCustomer>| <Gender> | <DateOfBirth> | <Address> | <City> | <State> | <PhoneNumber> | <Email> | <Password> |
    When el usuario valida campos obligatorios
    And el usuario modifica el estado a qwerty y el pin a 123456
    Then deberia visualizar el cambio de los campos
    
    Examples: 
      | NameCustomer| Gender | DateOfBirth | Address 			 | City	 | State  | PhoneNumber  | Email              | Password |
      | Pedro      	| Male	 | 15/02/1994  | street1st franklin  | Kansas| Kansas | 96211336	 | Petro16@kansas.com | asd123	 |
