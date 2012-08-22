mvn exec:java 


mvn assembly:assembly
java -Djava.library.path=c:\opencv_src\build\bin -jar target\opencv_java-0.0.1-jar-with-dependencies.jar 
java -Djava.library.path=c:\opencv_src\build\bin;C:\opencv_src\build\lib -jar target\opencv_java-0.0.1-jar-with-dependencies.jar 
java -Djava.library.path=C:\tools\OpenCV2.2\bin -jar target\opencv_java-0.0.1-jar-with-dependencies.jar 
java -Djava.library.path=C:\tools\OpenCV2.2\bin;C:\tools\OpenCV2.2\lib -jar target\opencv_java-0.0.1-jar-with-dependencies.jar 

java -Djava.library.path=C:\opencv_src\build\x64\mingw\bin -jar target\opencv_java-0.0.1-jar-with-dependencies.jar 
java -Djava.library.path=C:\opencv_src\build\x64\mingw\bin;C:\opencv_src\build\x64\mingw\lib -jar target\opencv_java-0.0.1-jar-with-dependencies.jar 

java -Djava.library.path=C:\opencv_src\build\x64\vc10\bin -jar target\opencv_java-0.0.1-jar-with-dependencies.jar 

java -Djava.library.path=C:\opencv_src\build\gpu\x64\vc10\bin;C:\opencv_src\build\gpu\x64\vc10\lib -jar target\opencv_java-0.0.1-jar-with-dependencies.jar 



SET PATH_DE=C:\Program Files\Common Files\Microsoft Shared\Windows Live;C:\Program Files (x86)\Common Files\Microsoft Shared\Windows Live;C:\Windows\system32;C:\Windows;C:\Windows\System32\Wbem;C:\Windows\System32\WindowsPowerShell\v1.0\;C:\Program Files\Java\jdk1.6.0_24\bin;C:\Program Files (x86)\apache-maven-3.0.4\bin;C:\Program Files (x86)\Windows Live\Shared


java -jar target\opencv_java-0.0.1-jar-with-dependencies.jar 

SET PATH=C:\opencv_src\build\gpu\x64\vc10\bin;C:\opencv_src\build\gpu\x64\vc10\lib;%PATH_DE%
SET PATH=C:\opencv_src\build\x64\vc10\bin;C:\opencv_src\build\x64\vc10\lib;%PATH_DE%

SET PATH=c:\opencv_src\build\bin;c:\opencv_src\build\lib;%PATH_DE%
SET PATH=C:\opencv_src\build\common\tbb\intel64\mingw;c:\opencv_src\build\bin;c:\opencv_src\build\lib;%PATH_DE%

SET PATH=C:\opencv_src\build\common\tbb\ia32\mingw;c:\opencv_src\build\bin;c:\opencv_src\build\lib;%PATH_DE%
SET PATH=C:\opencv_src\build\common\tbb\intel64\vc10;c:\opencv_src\build\bin;c:\opencv_src\build\lib;%PATH_DE%

SET PATH=C:\tools\OpenCV2.2\bin;C:\tools\OpenCV2.2\lib;%PATH_DE%


---------------------------
haar training
c:\tools\OpenCV2.2\bin\opencv_createsamples.exe -img C:\Users\jaoki\coding\git_playground\opencv_java\src\test\resources\uniqlo.png -vec C:\Users\jaoki\coding\git_playground\opencv_java\src\test\resources\uniqlo.vec


c:\tools\OpenCV2.2\bin\opencv_haartraining.exe -data C:\Users\jaoki\coding\git_playground\opencv_java\src\test\resources\data -vec C:\Users\jaoki\coding\git_playground\opencv_java\src\test\resources\uniqlo.vec -bg C:\Users\jaoki\coding\git_playground\opencv_java\src\test\resources\NG.txt -mode ALL


