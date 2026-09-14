# 設計模式思考筆記：網頁版

以根目錄 README 的六章概念重新編排為繁體中文教學網頁。保留原有 Java、example、drawio、README 與 JPG；不需要安裝前端套件。

## 啟動

需要 Node.js 20.11 以上版本。在專案根目錄執行：

```sh
npm start
```

開啟 http://localhost:4173 。也可執行 `node server.mjs`。使用 `PORT` 環境變數指定其他連接埠。伺服器僅綁定本機，並僅提供首頁、README 與 web 下的檔案。

Windows PowerShell 如果因執行原則擋住 `npm.ps1`，直接使用 `npm.cmd start`，不需要變更系統執行原則。

部署靜態網站時，複製 `index.html`、`README.md` 和 `web/` 即可。不需要建置步驟。頁面使用相對資源路徑，可置於子路徑。Google Fonts 是可選字型來源，載入失敗會使用系統中文字型。

## 內容與互動

- 六個閱讀章節、固定導覽、手機選單與依捲動更新的章節標記。
- SOLID 可用滑鼠、觸控、左右方向鍵、Home / End 切換。
- 23 個模式可搜尋、按三種分類篩選，並開啟用途與取捨說明。`/` 聚焦搜尋；Escape 關閉說明視窗。
- 分支重構前後比較、六階段設計演進、三組關係切換。
- 圖解有替代文字；使用者偏好減少動畫時停用平滑捲動與轉場。

## 圖片與原圖意圖對照

| 原圖 | 新版 |
| --- | --- |
| if-else炸裂.jpg | assets/branching.svg、branching-refactored.svg，展示分支膨脹與入口選擇 |
| 設計模式思考示意圖.jpg | assets/design-pattern-map.svg 十二種模式完整總覽、app.js 六階段互動圖，以及 23 種模式目錄 |
| 行為鏈示意圖.jpg | assets/behavior-chain.svg，展示跨物件的依序呼叫 |
| 物件關係示意圖.jpg | assets/object-relationships.svg，展示職責邊界與明確契約 |
| 多個物件關係表示.jpg | assets/object-coupling.svg，展示相依程度的概念比喻 |

向量圖依照既有 drawio 意圖以程式重繪，避免點陣中文字模糊；五組原圖意圖皆已涵蓋。重建靜態圖：`node web/generate-diagrams.mjs`。

完整思考總覽可在網頁第五章查看，或另開 `assets/design-pattern-map.svg`。重建命令：`node web/generate-pattern-map.mjs`。新版配色參考使用者提供的拾頁書友會圖片：奶油白底、深藍文字及按鈕，搭配薄荷綠、暖黃與珊瑚橘。章節勾選和進度儲存已移除。

首頁 `assets/hero.png` 使用內建 imagegen 生成，圖像表達模組、組合與協作；完整提示詞在 `image-prompts.md`。

## 編輯邊界

原文為個人觀點，頁面保留此定位。生活比喻改寫為設計提問；不把現實特例當作軟體原則的形式反例。Template Method 的繼承骨架與 Strategy 的組合替換明確分開；圖中重疊不代表可測量的耦合值。模式簡介為概念性補充，不引入 example 實作教學。

## 驗證

`npm run check` 檢查 JavaScript 語法。瀏覽器驗證紀錄見 `verification.md`。
