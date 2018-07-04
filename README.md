# Reactive-FileReader


## Flowable data emitter

The Flowable class that implements the Reactive-Streams Pattern and offers factory methods, intermediate operators and the ability to consume reactive dataflows.
Reactive-Streams operates with Publishers which Flowable extends. Many operators therefore accept general Publishers directly and allow direct interoperation with other Reactive-Streams implementations.

The Flowable hosts the default buffer size of 128 elements for operators, accessible via bufferSize(), that can be overridden globally via the system parameter rx2.buffer-size. Most operators, however, have overloads that allow setting their internal buffer size explicitly.

```
public Flowable<String> read(File file) {
    return Flowable.create(emitter -> {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        final String line = bufferedReader.readLine();
        if (line != null) {
            String[] splitted = line.split("\\s+");
            for (String word : splitted) {
                Thread.sleep(1000);
                emitter.onNext(word);
            }
            emitter.onComplete();
        } else {
            emitter.onComplete();
        }
    }, BackpressureStrategy.BUFFER);
}
```

## Dependencies used:

* RxJava -> Reactive Programming. (https://github.com/ReactiveX/RxJava)
* Dagger -> Inject dependencies. (https://google.github.io/dagger/)
* ButterKnife -> Bind views to java code easily and avoiding some code boilerplate. (http://jakewharton.github.io/butterknife/)
