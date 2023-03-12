@Execution
Feature: Automation for carousel in mall.cz page

  Scenario Outline: Validate quantity of elements for carousels in index page
    Given Navigate to mall.cz
    When Enter on the page find carousel "<carousel>"
    Then Validate the quantity of elements is "<quantity>"
    Examples:
      | carousel       | quantity |
      | TopIcon      | 15       |
#      | carouselB      | 15       |
#      | CategoryBanner | 15       |
#      |         | 15       |
