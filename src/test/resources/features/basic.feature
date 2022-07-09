Feature: basic

  Scenario: scenario
    Given visit duck duck go
    When I search for String FluentLenium
    Then Title contains FluentLenium
