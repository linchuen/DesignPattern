# 網頁驗證紀錄

日期：2026-09-14。使用本機 `http://localhost:4173`，透過 Playwright 真實 Chromium 瀏覽器操作；未執行 Java example。

## 第二版更新驗證

- 已移除六章勾選、側欄進度、完成訊息及 localStorage 相關程式；下方第一版的進度測試僅為歷史紀錄。
- 參考提供的拾頁書友會圖片，更新奶油白、深藍、薄荷綠、暖黃與珊瑚橘配色。
- 新增獨立 `design-pattern-map.svg`，涵蓋原圖主要模式並加入 Bridge；確認頁面載入及另開大圖正常。
- Chromium 實測模式列表與分類、手機導覽正常；390、768、1440px 無頁面橫向溢出。
- `npm.cmd run check` 通過。
- 新版畫面：[桌面](evidence/desktop-color-v2.png)、[手機](evidence/mobile-color-v2.png)、[完整總覽圖](assets/design-pattern-map.svg)。

## PASS

- `npm.cmd run check`：app.js 與 server.mjs 語法正確。
- 原始 23 個模式完整呈現；創建 5、結構 7、行為 11 個篩選結果正確。
- 中文關鍵字搜尋、清除搜尋、無結果提示。搜尋包含模式說明與取捨，因此 `Strategy` 也會找到提到此名稱的 Template Method。
- 點擊模式開啟對應說明；關閉按鈕、返回按鈕、Escape 均可關閉；焦點返回觸發按鈕。
- SOLID 五個原則切換；左右方向鍵切換原則。
- 六個設計演進階段更新圖像、選取狀態與說明。
- 分支前後比較與三個物件關係 SVG 全部載入成功。
- 勾選章節後重新整理仍保留進度；勾完六章顯示完成訊息；取消勾選後同步更新。測試完成已重設為 0 / 6。
- `/` 快捷鍵聚焦模式搜尋；所有章節錨點都有對應內容。
- 手機選單開關、選擇章節後自動收合。收合時隱藏導覽不參與鍵盤焦點；回到桌面時恢復導覽。
- 320、390、768、1024、1440 CSS px 寬度皆無頁面橫向溢出。
- 手機 SVG 圖解維持 700px 閱讀寬度，僅在圖解區內左右捲動，已驗證可捲動。
- 桌面及手機首頁、手機圖解、桌面演進圖皆已截圖並人工檢視。
- 互動操作期間未捕捉到 JavaScript pageerror。

## 畫面證據

- [桌面首頁](evidence/desktop.png)
- [手機首頁](evidence/mobile.png)
- [手機可捲動圖解](evidence/mobile-diagram.png)
- [互動演進圖](evidence/interactive-diagrams.png)

## 未測範圍

Safari、Firefox、實體手機、螢幕閱讀器、靜態託管部署及瀏覽器禁用儲存環境尚未實測。響應式檢查使用 Chromium 視窗尺寸模擬，不宣稱實體裝置測試。
