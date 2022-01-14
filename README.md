# load-testing-Gtatling


>## A [Giter8][g8] template for [Gatling][gatling] performance test suite

```
sbt new gatling/gatling.g8
```

For more information on suite, have a look at example [applied template][example].

[g8]: http://www.foundweekends.org/giter8/
[gatling]: https://gatling.io
[example]: https://github.com/spikerlabs/performance-test-suite-example
[@asarturas]: https://github.com/asarturas

>## Test - performance test suite

Project uses [sbt plugin][sbtplugindoc] of [gatling][gatlingdoc].
It contains basic simulation from gatling quick start bundle.

[sbtplugindoc]: https://gatling.io/docs/current/extensions/sbt_plugin/
[gatlingdoc]: https://gatling.io/docs/current/advanced_tutorial/

### Run

All tests:
```
sbt "gatling:test"
```

Single test:
```
sbt "gatling:testOnly computerdatabase.BasicSimulation"
```

Report:
```
sbt "gatling:lastReport"
```