# ********RoostGPT********

# Test generated by RoostGPT for test karateTest2April using AI Type Open AI and AI Model gpt-4
# 
# Feature file generated for /recipients/branches/{id}/registrations_get for http method type GET 
# RoostTestHash=49b35fa9c1
# 
# 

# ********RoostGPT********
Feature: Recipient Branch API

Background:
  * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:8080')
  * url urlBase
  * def AUTH_TOKEN = karate.properties['AUTH_TOKEN']
  * def AuthHeaders = { 'ApiKeyAuth': '#(AUTH_TOKEN)' }

Scenario Outline: Test GET method on /recipients/branches/{id}/registrations endpoint
  Given path 'recipients', 'branches', '<id>', 'registrations'
  And params { 'credential-url': '<credential-url>', 'size': '<size>', 'offset': '<offset>' }
  And headers AuthHeaders
  When method get
  Then status <status_code>
  And match responseHeaders['api-version'] == '<api_version>'
  And match responseHeaders['page-size'] == '<page_size>'
  And match responseHeaders['page-offset'] == '<page_offset>'
  And match response contains { 'total': '#number', 'registrations': '#[] object' }

  Examples:
  | id | credential-url | size | offset | status_code | api_version | page_size | page_offset |
  | '1234-5678-9101' | 'https://example.com' | 20 | 0 | 200 | '1.0.0' | 20 | 0 |
  | '1234-5678-9101' | 'https://example.com' | 50 | 10 | 200 | '1.0.0' | 50 | 10 |
  | '1234-5678-9101' | 'https://example.com' | 1 | 0 | 401 | '1.0.0' | 1 | 0 |
  | '1234-5678-9101' | 'https://example.com' | 20 | 0 | 400 | '1.0.0' | 20 | 0 |
