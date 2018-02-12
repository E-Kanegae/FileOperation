# FileOperation
FileInputStreamとFileOutputStreamの実装確認用

### クラス構成
* *txtfile.make* パッケージ
 1. *TextFileMaker.java*
sampleのテキストファイルを出力するクラス。　*C:\temp* 下に1GBのファイルを作成する。  

* *txtfile.execute* パッケージ
 1. *OutOfMemoryExec.java*
 2. *LineStreamExec.java*
 3. *LineStreamJava8Exec.java*
 4. *LineStreamMultiInputFilesExec.java*
     
   - ***txtfile.execute* パッケージのクラスの説明**    
  
1. *txtfile.make.TextFileMaker.java* で作成したファイルを一気に読み込んでOutOfMemoryが発生するクラス。
2. *txtfile.make.TextFileMaker.java* で作成したファイルを一行づつ読み込み、出力するクラス。
3. *2.* をjava8のstreamで実装したクラス。
4. 指定ディレクトリ配下の複数ファイルを全て一行づつ読み込み、1つのファイルに出力するクラス。
  
InputStreamとOutputStreamの単なる確認なので、nullチェック等は特に実装なし。  
