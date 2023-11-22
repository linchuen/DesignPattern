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
- (SRP) 單一職責
- (OCP) 開放/封閉原則
- (LSP) Liskov替換
- (ISP) 介面隔離
- (DIP) 依賴反轉