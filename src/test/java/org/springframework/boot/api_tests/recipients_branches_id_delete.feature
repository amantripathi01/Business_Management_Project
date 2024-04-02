# ********RoostGPT********

# Test generated by RoostGPT for test karateTest2April using AI Type Open AI and AI Model gpt-4
# 
# Feature file generated for /recipients/branches/{id}_delete for http method type DELETE 
# RoostTestHash=1ce4bf6e3c
# 
# 

# ********RoostGPT********
Feature: Recipient Branch API

Background:
* def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:8080')
* url urlBase
* def authToken = karate.properties['AUTH_TOKEN']
* configure headers = { ApiKeyAuth: '#(authToken)' }

Scenario Outline: Test GET /recipients/branches/{id} endpoint
  Given path '/recipients/branches/', '<id>'
  When method GET
  Then status <status_code>

  And match responseHeaders contains { 'api-version': '#string' }
  And match responseHeaders['api-version'] == '1.0.0'

  * def responseSchema = 
    """
    {
      oneOf: [
        {
          required: ['description','error'],
          type: 'object',
          properties: {
            error: { type: 'string', example: 'error/code' },
            description: { type: 'string', example: 'Descriptive Error Message' }
          }
        },
        {
          required: ['description','error','schema_field','value'],
          type: 'object',
          properties: {
            error: { pattern: '^validation/.*', type: 'string', example: 'validation/email-pattern' },
            description: { type: 'string', example: 'Descriptive Error Message' },
            value: {},
            field: { type: 'string' },
            schema_field: { type: 'string' }
          }
        }
      ]
    }
    """
  And match response == responseSchema

Examples:
| id                                | status_code |
| '3fa85f64-5717-4562-b3fc-2c963f66afa6' | 200         |
| 'invalid-id'                      | 400         |
| ''                                | 401         |
