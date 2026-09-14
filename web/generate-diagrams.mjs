// Rebuild deterministic, accessible vector diagrams from the intent of the original drawio/JPG figures.
import { writeFile } from 'node:fs/promises';
const dir = new URL('./assets/', import.meta.url);
const text = (x,y,label,size=15,fill='#20243b',anchor='middle') => `<text x="${x}" y="${y}" font-size="${size}" fill="${fill}" text-anchor="${anchor}">${label}</text>`;
const node = (x,y,w,h,label,sub='',fill='#fff') => `<rect x="${x}" y="${y}" width="${w}" height="${h}" rx="12" fill="${fill}" stroke="#bddbd0"/>${text(x+w/2,y+h/2+(sub?-3:5),label,15)}${sub?text(x+w/2,y+h/2+18,sub,11,'#819571'):''}`;
const line = (x1,y1,x2,y2,arrow=true,color='#4e9c83',dash='') => `<path d="M${x1} ${y1} L${x2} ${y2}" stroke="${color}" stroke-width="1.7" ${dash?`stroke-dasharray="${dash}"`:''} ${arrow?'marker-end="url(#arrow)"':''} fill="none"/>`;
const group = (x,y,w,h,label,fill='#e1f1e9') => `<rect x="${x}" y="${y}" width="${w}" height="${h}" rx="22" fill="${fill}" stroke="#d7e1ce"/>${text(x+24,y+34,label,14,'#7a8e69','start')}`;
function svg(title,body) { return `<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 900 360" role="img" aria-labelledby="title"><title id="title">${title}</title><defs><marker id="arrow" viewBox="0 0 10 10" refX="9" refY="5" markerWidth="6" markerHeight="6" orient="auto"><path d="M0 0 L10 5 L0 10" fill="#4e9c83"/></marker></defs><g font-family="Noto Sans TC,Microsoft JhengHei,system-ui,sans-serif">${body}</g></svg>\n`; }
let branching = text(130,44,'單一入口',12,'#829373') + text(390,44,'條件不斷增加',12,'#829373') + text(750,44,'更多可能路徑',12,'#b08460');
branching += line(205,185,320,185) + line(430,185,540,105) + line(430,185,540,265);
branching += node(55,150,150,70,'原始函式','一個簡單任務','#e1f1e9') + node(320,150,110,70,'條件 A','if / else','#ffe4d9');
for (const y of [105,265]) { branching += node(540,y-27,88,54,'條件 B','','#ffe4d9'); for(const d of [-38,38]) { branching += line(628,y,699,y+d); branching += node(699,y+d-17,69,34,'C','','#fff0c6'); for(const e of [-12,12]) { branching += line(768,y+d,824,y+d+e,false,'#c6b89c'); branching += `<circle cx="834" cy="${y+d+e}" r="7" fill="#ed9871"/>`; } } }
let after = text(152,53,'把選擇集中在入口',13,'#7b8c6d') + text(622,53,'把變化封裝在實作',13,'#7b8c6d');
after += line(255,180,370,180) + line(490,180,600,95) + line(490,180,600,180) + line(490,180,600,265);
after += node(65,146,190,68,'處理請求','選擇適合的行為','#dff1e9') + node(370,146,120,68,'策略介面','共同契約','#fff0c6');
for (const [i,y] of [95,180,265].entries()) after += node(600,y-31,230,62,`策略 ${String.fromCharCode(65+i)}`,'各自完成自己的流程');
let chain = group(40,56,390,243,'物件 A') + group(470,56,390,243,'物件 B','#fff0c6');
chain += line(219,179,254,179) + line(395,179,503,179) + line(649,179,684,179);
chain += node(75,148,144,62,'行為 1','呼叫下一步')+node(254,148,141,62,'行為 2','跨越物件邊界')+node(503,148,146,62,'行為 3','繼續傳遞')+node(684,148,141,62,'行為 4','完成任務');
chain += line(450,35,450,323,false,'#b7c2aa','4 6')+text(450,334,'沿著鏈條追蹤整個流程',12,'#8c987e');
let objects = group(40,35,330,286,'物件 A · 自己的職責') + group(530,35,330,286,'物件 B · 自己的職責','#fff0c6');
objects += line(205,146,145,221) + line(205,146,282,221) + line(695,146,635,221) + line(695,146,772,221) + line(292,116,390,116) + line(510,116,608,116);
objects += node(118,83,174,65,'協調自己的行為','物件 A','#fff') + node(608,83,174,65,'協調自己的行為','物件 B','#fff') + node(390,88,120,56,'明確契約','','#dcf0e7');
objects += node(75,221,135,58,'行為 A1')+node(227,221,112,58,'行為 A2')+node(565,221,135,58,'行為 B1')+node(717,221,112,58,'行為 B2');
objects += text(450,251,'互動有界線',13,'#718562')+text(450,275,'細節留在內部',11,'#99a48b');
let coupling = `<circle cx="255" cy="167" r="137" fill="#dbf0e6" stroke="#a8bc91"/><circle cx="403" cy="220" r="109" fill="#8eceb6" fill-opacity=".55" stroke="#9eb686"/><circle cx="452" cy="93" r="81" fill="#ffe7a0" fill-opacity=".72" stroke="#c1c29f"/><circle cx="727" cy="206" r="97" fill="#e8f1f2" stroke="#bccbad"/>`;
coupling += text(201,144,'物件 A',19)+text(441,227,'物件 C',18)+text(464,79,'物件 B',16)+text(727,206,'物件 D',18)+text(727,230,'相對獨立',12,'#8a9b7b');
coupling += text(341,219,'高度相依',14,'#577447')+text(382,116,'少量相依',11,'#84905f')+line(572,44,572,316,false,'#b9c5ae','4 7')+text(333,344,'共享細節越多，變更越可能互相牽動',12,'#849273');
await Promise.all([
  ['branching.svg','條件判斷從單一函式擴張成八條可能路徑',branching],
  ['branching-refactored.svg','在入口選擇策略，讓各策略封裝自己的行為',after],
  ['behavior-chain.svg','行為跨越物件邊界依序呼叫',chain],
  ['object-relationships.svg','物件各自協調內部行為，透過明確契約合作',objects],
  ['object-coupling.svg','以重疊比喻物件間的相依程度',coupling]
].map(([name,title,body]) => writeFile(new URL(name,dir), svg(title,body))));
console.log('Generated 5 accessible SVG assets. The six-stage concept map is rendered interactively in app.js.');
