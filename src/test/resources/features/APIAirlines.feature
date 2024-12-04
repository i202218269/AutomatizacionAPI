@Airlines
Feature: Obtener todas las aerolineas
  Como un usuario de la API de aerolineas
  Quiero obtener la lista de todas las aerolineas
  Para poder verificar los detalles de las aerolineas disponibles

  @CP1
  Scenario: Obtener todas las aerolineas exitosamente
    Given el actor establece el endpoint para obtener las aerolineas
    When el actor envia una solicitud GET
    Then el codigo de respuesta deberia ser 200

  @CP02S
  Scenario Outline: Crear una aerolinea exitosamente
    Given el actor establece el endpoint POST para crear una aerolinea
    When el envia una solicitud HTTP POST con el "<_id>" "<name>" "<country>" "<logo>" "<slogan>" "<head_quaters>" "<website>" "<established>"
    Then el codigo de respuesta deberia ser 200

    Examples:
      | _id | name           | country | logo     | slogan                   | head_quaters | website     | established |
      | 1   | Ramon Castilla | Lima    | lima.png | Miraflores ciudad amable | Miraflores   | flowers.com | 1857        |
      | 3   | Alfredo Parodi | Lima    | lima.png | Centro financiero        | San Isidro   | isidro.pe   | 1931        |

  @CP03
  Scenario Outline: Actualizar una aerolinea exitosamente
    Given el actor establece el endpoint PUT para actualizar una aerolinea
    When el envia una solicitud HTTP PUT con el "1" "Luis Poma" "Trujillo" "trujillo.png" "Trujillo ciudad segura" "Trujillo" "trujillo.com" "1995"
    Then el codigo de respuesta deberia ser 404

    Examples:
      | _id | name      | country  | logo         | slogan                 | head_quaters        | website      | established |
      | 1   | Luis Poma | Trujillo | trujillo.png | Trujillo ciudad segura | Trujillo | trujillo.com | 1995        |

  @CP04
  Scenario: Eliminar una aerolinea exitosamente
    Given el actor establece el endpoint DELETE para eliminar una aerolinea
    When el envia una solicitud HTTP DELETE con el "1"
    Then el codigo de respuesta deberia ser 404



