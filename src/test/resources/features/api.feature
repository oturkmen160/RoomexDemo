@api @wip
Feature: Post has email comment


  Scenario: check comments if they have email
    When get request for a random post
    Then each comment has an email address