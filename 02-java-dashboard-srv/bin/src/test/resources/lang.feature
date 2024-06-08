Feature: Language

  @GetValidLanguage
  Scenario Outline: Scan string for valid language
    Given I have repo name <str> with a language
    When I lookup language <lang> in language table
    Then I check langModel not null
    And I check portalModel langId is set
    Examples:
    | str                      | lang    |
    | "ansible-lib"   | "ansible"  |
    | "saltstack-lib"   | "saltstack"  |
    | "aspnet-web-hello-world"   | "aspnet"  |
    | "chef-cli-lib"   | "chef"  |
    | "java-cli-hello-world"   | "java"  |
    | "groovy-cli-hello-world"   | "groovy"  |
    | "kotlin-cli-hello-world"   | "kotlin"  |
    | "scala-cli-hello-world"   | "scala"  |
    | "rust-cli-hello-world"   | "rust"  |
    | "dart-cli-hello-world"   | "dart"  |
    | "c-cli-hello-world"   | "c"  |
    | "cpp-cli-hello-world"   | "cpp"  |
    | "csharp-cli-hello-world"   | "csharp"  |
    | "perl-cli-hello-world"   | "perl"  |
    | "python-cli-hello-world"   | "python"  |
    | "php-web-hello-world"   | "php"  |
    | "nodejs-cli-hello-world"   | "nodejs"  |
    | "javascript-cli-hello-world"   | "javascript"  |
    | "flutter-web-hello-world"   | "flutter"  |
    | "clojure-cli-hello-world"   | "clojure"  |
    | "ruby-cli-hello-world"   | "ruby"  |
    | "vbnet-cli-hello-world"   | "vbnet"  |
    | "bash-cli-hello-world"   | "bash"  |
    | "erlang-cli-hello-world"   | "erlang"  |
    | "elixir-cli-hello-world"   | "elixir"  |
    | "haskel-cli-hello-world"   | "haskel"  |
    | "julia-cli-hello-world"   | "julia"  |
    | "golang-cli-hello-world"   | "golang"  |
    | "powershell-cli-hello-world"   | "powershell"  |
    | "swift-cli-hello-world"   | "swift"  |
