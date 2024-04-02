# ********RoostGPT********

# Test generated by RoostGPT for test karateTest2April using AI Type Open AI and AI Model gpt-4
# 
# Feature file generated for /grants_get for http method type GET 
# RoostTestHash=692c6b853f
# 
# 

# ********RoostGPT********
Feature: Retrieve accounts with granted access permissions

Background:
    * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:8080')
    * url urlBase
    * def authToken = karate.properties['AUTH_TOKEN']
    * configure headers = { ApiKeyAuth: '#(authToken)' }

Scenario Outline: Get grants
    Given path '/grants'
    When method get
    Then status 200
    And match responseHeaders contains { 'api-version': '1.0.0' }
    And match response == { total: '#number', grants: '#[] grants' }
    And match each grants == { id: '#uuid', token: '#regex^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}:[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$', createdAt: '#string', updatedAt: '#string', account: '#object' }
    And match each grants.account == { id: '#uuid', name: '#regex^[\\p{L} .'-]{1,100}$', image: '#? string', email: '#regex^(([^<>()[\\]\\\\.,;:\\s@\\\"]+(\\.[^<>()[\\]\\\\.,;:\\s@\\\"]+)*)|(\\\".+\\\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$' }

Scenario: Unauthorized access
    Given path '/grants'
    And header ApiKeyAuth = 'invalid_token'
    When method get
    Then status 401
    And match responseHeaders contains { 'api-version': '1.0.0' }
    And match response == { error: 'error/code', description: 'Descriptive Error Message' }
