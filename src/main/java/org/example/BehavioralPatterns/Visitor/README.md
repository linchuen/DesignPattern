訪客模式
===
問題
---
當新增業務需要依賴既有物件行為實現，而職責不屬於原有物件所有，如果在既有物件擴充其相關邏輯，其責任歸屬會混亂。

意图
---
- 將行為與作用對象隔離開來
- 單一職責