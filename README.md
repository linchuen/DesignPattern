# 1.看待程式語言
&emsp;&emsp;維基百科定義程式語言是用來定義電腦程式的形式語言。
一種能夠讓程式設計師標準化向電腦發出指令得到需要使用資料的電腦語言。

&emsp;&emsp;對於剛踏入這領域的新手來說，程式語言更接近專業領域的工具，
但是軟體工程所要解決的問題，向來都是現實發生的問題只不過是透過電腦來解決，
因此看待程式語言的角度，可以從單純向電腦發指令的工具轉變為更接近工程師交流的自然語言。

&emsp;&emsp;如果程式語言是工程師彼此之間交流媒介的話，那麼程式可讀性就是相當重要的事情，
就好比中文有文言文和白話文，就算是很精通文言文的人一般對話也不會選擇文言文來溝通，
因此撰寫好閱讀的程式是相當重要的課題，也就為何會出現clean code概念的原因。

# 2.看待物件導向
### 程式中的物件
基本上在程式語言中透過類別生成的東西就是物件，所以看的到的幾乎都是物件。
### 常見程式設計
因為程式中的類別產生就是物件，因此設計上會使用類別去對應現實的物件，
並且使用方法去對應物件的行為，但是現實的物件通常有各式各樣的行為，
為了不產生出一個擁有全部行為的龐大類，所以將各種行為拆分至不同的類別裡面。
<br>
### 物件定義
參照現實中的各種物件，物件應具有不同的行為。
### 行為定義
由不同的動作或是更具體的行為，透過一連串流程組成。
### 資料定義
用於描述物件的狀態，本身僅提供數值或屬性，例如:顏色、姓名...，並且能夠識別出個體差異。  

### 物件導向三大特色
按涵蓋範圍排序
1. **封裝**  
   隱藏細節，並將具體的內容抽象化，這邊分為基於物件、行為、資料三個面向進行抽象。
2. **多型**  
   基於被抽象的概念用不同的實例實作，來達到相同行為不同的表現
3. **繼承**  
   基於已被實作的實例拓展，來完成使用類別間的重複定義。

>物件導向本質上都是為了能夠重複利用

# 3.物件導向設計原則 - SOLID

這邊稱SOLID為設計原則，代表在特定情境下會有不適用的情況，所以並不像真理如生物會死亡強烈
，因此在設計時不用過度糾結時否都要滿足原則定義，可遵守80/20法則及當時情況判斷。

- (Single Responsibility Principle) 單一職責  
原文:*"There should never be more than one reason for a class to change."*  
物件都傭有各自的職責，越抽象的物件、行為會涵蓋較大的職責，而越具體的物件、行為會有明確且清晰的職責也接近細節的呈現。
>例子: 工程師有工程師的職責、pm有pm的職責，彼此互不干涉其工作方式，而各自的職責又能分成多個細項

>違反情境: 當同事或主管請假的時候，職務代理人此時就會打破此原則，負責其他人的職責
- (Open Closed Principle) 開放/封閉原則  
原文:*"Software entities ... should be open for extension, but closed for modification."*  
處理新的功能能夠在既有結構下完成功能的新增，在修改既有功能能夠不更動既有架構達到目的，簡言之，每次新增/修改功能都是獨立事件。

>例子: 每顆燈泡都是獨立運作的，不會因為加了一顆燈泡別顆燈泡因此不亮，或者跟換成黃色燈泡原本的白色燈泡變成黃燈

>違反情境: 當頒布新的法律或修改法律時，公司運作就必須配合新的法律規則變更其運作方式
- (Liskov Substitution Principle) Liskov替換  
原文:*"Functions that use pointers or references to base classes must be able to use objects of derived classes without knowing it."*  
子類別在擴展父類別的功能,應遵守父類別原有的功能的意圖。

>例子: 腳踏車不管是輪子改裝成方形的或是三角形的都要能夠正常的騎乘  
> [三角形腳踏車視頻](https://www.youtube.com/watch?v=Q6SaDFYw1Fc)  
>[方形腳踏車視頻](https://www.youtube.com/shorts/MDCXoEqM-iQ)

>違反情境: 現實總是有特例，例如:企鵝不能飛、彈塗魚可以在地上爬、肺魚可以不用鰓呼吸
- (Interface Segregation Principle) 介面隔離  
原文:*"Clients should not be forced to depend upon interfaces that they do not use."*
使用者不應該知道與自己無關的功能，應只關心自己需要的功能

>例子: 一般人開車不需要知道汽車內部實際的運作原理，只要懂得怎麼開車就好

>違反情境: 食品標示上常常會出現工廠生產線含有過敏成分，一般人這訊息是多餘的，但對過敏的人極為重要
- (Dependency inversion principle) 依賴反轉
原文:*"Depend upon abstractions, not concretions."*  
應依賴於抽象的概念，而不是依賴於具體細節

>例子: 網球上手發球，其步驟為拋球、瞄準、打擊，而不是依賴於球拍固定角度，如直球發球與曲球發球的角度就不一樣

>違反情境: 正常情況下，門只能由同一形狀的鑰匙打開，而不是任一把鑰匙都能開
# 4.看待程式運作與設計
&emsp;&emsp;在了解程式是如何具體運作前，可以從why、what、how三個面向去了解，程式本身很擅長告訴工程師是如何運作的，
每一行程式代碼都透露出程式運作的細節，然而方法可以簡單的將細節封裝成一個抽象概念，能向工程師傳達程式在做什麼，
因此能將程式拆分成不同的小方法能夠幫助工程師們用更為抽象的方式理解程式，說完了what和how，
有沒有發現程式本身很難傳達why，想要了解程式為什麼要這麼做就需要知道整體的上下文、情境才能知曉，
所以這時候添加註解可以向其他人傳達程式背後的意圖，或是用常理去設計功能，可降低閱讀者認知的負擔。
> 對於註解每個人都有不同的看法， 不過註解並不能測試也無法透過QA達到驗證，因此撰寫註解應小心且謹慎  
> #### 有益的註解:
> - 法律型的註解
> - 資訊型註解
> - 對意圖的解釋
> - 闡釋
> - 警告
> - 待辦事項

# 5.看待Design Pattern運用
### Design Pattern使用
程式隨著開發功能越來越多，程式執行流程逐漸變得複雜，久而久之逐漸成為「大泥球」，
變得湊綜複雜，可維護性降低，間接造成對新人不友善、過度依賴資深員工，為了避免大泥球即早出現，
使用Design Pattern是一個很好出發點，主要是降低複雜度、抽象化細節、可重複利用程式代碼，
不過每個模式都有自己適合的情境，並不存在完美的方案，用與不用取決於個人的取捨。

### Design Pattern分類
#### 創建模式(Creational patterns)
此類模式主要關注物件的創建  
1. Factory Method
2. Abstract Factory
3. Builder
4. Prototype
5. Singleton
#### 結構模式(Structural patterns)
此類模式主要關注如何讓物件能夠具備彈性適應變化  
1. Adapter
2. Bridge
3. Composite
4. Decorator
5. Facade
6. Flyweight
7. Proxy
#### 行為模式(Behavioral patterns)
此類模式主要關注行為間的交互關係  
1. Chain of Responsibility
2. Command
3. Iterator
4. Mediator
5. Memento
6. Observer
7. State
8. Strategy
9. Template Method
10. Visitor
11. Interpreter

### 個人的分類
#### 可用於消除if-else的模式
這邊並不是完全消除if判斷，而是讓程式在流程上能夠在高層次就決定流程的走向，讓低層次能夠專注於自己的步驟。  
舉例:用戶在發送請求之前，就已經決定身分  
(Template Method是反向模式)
- Factory Method
- Abstract Factory
- Bridge
- State
- Strategy
- Template Method
> [if-else炸裂示意圖](https://github.com/linchuen/DesignPattern/blob/master/if-else%E7%82%B8%E8%A3%82.jpg?raw=true)
##### 處理資料
- Prototype
- Flyweight
- Adapter

#### 其餘

### 概念圖
![](https://github.com/linchuen/DesignPattern/blob/master/%E8%A8%AD%E8%A8%88%E6%A8%A1%E5%BC%8F%E6%80%9D%E8%80%83%E7%A4%BA%E6%84%8F%E5%9C%96.jpg?raw=true)
概念說明:   
起始物件(後面用使用者表示，比較貼近現實)可能只有一種，隨著需求變化，使用者種類開始變多，可以考慮使用工廠模式