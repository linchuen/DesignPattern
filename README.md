# 1.看待程式語言
&emsp;&emsp;維基百科定義程式語言是用來定義電腦程式的形式語言。
一種能夠讓程式設計師標準化向電腦發出指令得到需要使用資料的電腦語言。

&emsp;&emsp;對於剛踏入這領域的新手來說，程式語言更接近專業領域的工具，
但是軟體工程所要解決的問題，向來都是現實發生的問題只不過是透過電腦來解決，
因此看待程式語言的角度，可以從單純向電腦發指令的工具轉變為更接近工程師交流的自然語言。

&emsp;&emsp;如果程式語言是工程師彼此之間交流媒介的話，那麼程式可讀性就是相當重要的事情，
就好比中文有文言文和白話文，就算是很精通文言文的人一般對話也不會選擇文言文來溝通，
因此好閱讀的程式是相當重要的課題，也就為何會出現clean code概念的原因。

## 現代物件導向程式語言三大特色
按涵蓋範圍排序
1. **封裝**  
隱藏細節，並將具體的內容抽象化，這邊分為基於物件、行為、資料三個面向進行抽象。
2. **多型**  
基於被抽象的概念用不同的實例實作，來達到相同行為不同的表現
3. **繼承**  
基於已被實作的實例拓展，來完成使用類別間的重複定義。

>物件導向本質上都是為了能夠重複利用

# 2.看待物件導向設計
## 物件定義
泛指帶有行為的物體，對應現實中的各種物件。
## 資料定義
只提供數值或屬性，用於描述現實的物件，例如:顏色、姓名...
## 程式中的物件
基本上在程式語言中使用類別生成的東西就是物件，所以看的到的幾乎都是物件。
## 常見程式設計
因為程式中的類別產生就是物件，因此設計上會使用類別去對應現實的物件，
但又因為現實的物件具有過多的行為並不會將全部行為都寫入同一個類別內，
而將各種行為拆分至不同的類別裡面。

# 物件導向設計原則 - SOLID
這邊稱SOLID為設計原則，選用原則這詞代表在特定情境下會有不適用的情況，所以並不像生物會死亡這種真理強烈
，因此在設計時不用過度糾結時否都有滿足原則定義，可遵守80/20法則及當時情況判斷。
---
- (Single Responsibility Principle) 單一職責  
原文:*"There should never be more than one reason for a class to change."*  
物件都傭有各自的職責，越抽象的物件、行為會涵蓋較大的職責，而越具體的物件、行為會有明確且清晰的職責也接近細節的呈現。
>例子: 工程師有工程師的職責、pm有pm的職責，彼此互不干涉其工作方式，而各自的職責又能分成多個細項

>違反情境: 當同事或主管請假的時候，職務代理人此時就會打破此原則，負責其他人的職責
- (Open Closed Principle) 開放/封閉原則  
原文:*"Software entities ... should be open for extension, but closed for modification."*  
處理新的功能能夠在既有結構下完成功能的新增，在修改既有功能能夠不更動既有架構達到目的，簡言之，每次新增/修改功能都是獨立事件。

>例子: 每顆燈泡都是獨立運作的，不會因為加了一顆燈泡別顆燈泡因此不亮，或者跟換成黃色燈泡原本的白色燈泡變成黃燈

> 違反情境: 當頒布新的法律或修改法律時，公司運作就必須配合新的法律規則變更其運作方式
- (Liskov Substitution Principle) Liskov替換  
原文:*"Functions that use pointers or references to base classes must be able to use objects of derived classes without knowing it."*
- (Interface Segregation Principle) 介面隔離  
原文:*"Clients should not be forced to depend upon interfaces that they do not use."*
- (Dependency inversion principle) 依賴反轉
原文:*"Depend upon abstractions, not concretions."*