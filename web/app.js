const $ = (selector) => document.querySelector(selector);
const $$ = (selector) => [...document.querySelectorAll(selector)];
const solid = [
  ['S', '單一職責', 'Single Responsibility Principle', '讓變更的理由保持聚焦。', '一個類別應有清楚、聚焦的職責，避免不同角色的需求變動互相牽動。像工程師與 PM 分別負責自己的工作；職責可以再細分，但不代表每個類別只能有一個方法。', '當需求改變時，這個類別會因為幾種不同角色的理由而被修改？'],
  ['O', '開放／封閉', 'Open–Closed Principle', '讓新的變化，有可以擴充的位置。', '對預期的變化提供擴充點，盡量避免反覆更動穩定的核心流程。像替換燈泡時，保留既有插座與電路。這不代表程式永遠不能修改，而是選擇值得保護的邊界。', '新增一種行為時，可以加入新的實作，還是得修改很多既有分支？'],
  ['L', 'Liskov 替換', 'Liskov Substitution Principle', '替換實作，仍然遵守原本的承諾。', '使用父型別的地方，應能換成子型別而不破壞原本的正確性。像更換腳踏車輪子之後仍能騎乘。現實中的特例提醒我們：繼承關係必須以行為契約判斷。', '如果換成另一個子類別，呼叫者是否還要額外檢查，才能避免行為出錯？'],
  ['I', '介面隔離', 'Interface Segregation Principle', '只依賴真正需要的能力。', '讓介面按照使用者的需要劃分，避免被迫依賴用不到的方法。開車的人需要駕駛操作，維修人員需要維修能力；各自的介面可以對應各自的需求。', '這個介面是否要求某些實作提供空方法，或承擔完全不需要的功能？'],
  ['D', '依賴反轉', 'Dependency Inversion Principle', '讓高層規則，依賴穩定的抽象。', '高層流程與低層細節都依賴抽象，讓具體實作可以替換。像先定義拋球、瞄準與打擊的發球概念，再選擇不同擊球方式；抽象仍要清楚約定必要的能力。', '替換外部服務或儲存方式時，核心的業務流程需要跟著重寫嗎？']
];
$('.solid-tabs').innerHTML = solid.map((s, i) => `<button role="tab" id="solid-tab-${i}" aria-selected="${i === 0}" aria-controls="solid-panel" tabindex="${i === 0 ? 0 : -1}" data-solid="${i}"><b>${s[0]}</b><span>${s[1]}</span></button>`).join('');
function showSolid(index, focus = false) {
  const s = solid[index];
  $$('[data-solid]').forEach((button, i) => { button.setAttribute('aria-selected', i === index); button.tabIndex = i === index ? 0 : -1; if (focus && i === index) button.focus(); });
  $('#solid-panel').setAttribute('aria-labelledby', `solid-tab-${index}`);
  $('#solid-panel').innerHTML = `<p class="eyebrow">${s[2]}</p><h3>${s[3]}</h3><p>${s[4]}</p><p class="solid-question">設計提問 → ${s[5]}</p>`;
}
$$('[data-solid]').forEach((button, i) => { button.addEventListener('click', () => showSolid(i)); button.addEventListener('keydown', (event) => { let next; if (event.key === 'ArrowRight') next = (i + 1) % 5; if (event.key === 'ArrowLeft') next = (i + 4) % 5; if (event.key === 'Home') next = 0; if (event.key === 'End') next = 4; if (next !== undefined) { event.preventDefault(); showSolid(next, true); } }); });
showSolid(0);

const patterns = [
  ['Factory Method', '工廠方法', 'creational', '將物件建立交給可覆寫的工廠方法。', '當共同流程需要建立物件，但具體種類要由子類別決定。', '會增加子類別；只有一種穩定的建立方式時，可能不需要它。'],
  ['Abstract Factory', '抽象工廠', 'creational', '一起建立互相搭配的一整組物件。', '當系統需要切換不同產品家族，並保持家族內的相容性。', '新增產品家族容易，新增一種產品角色則可能要改動所有工廠。'],
  ['Builder', '建造者', 'creational', '分步組裝，隔離複雜物件的建立細節。', '當物件有多個組裝步驟，或相同步驟需要產生不同表示。', '額外的建造者與流程對簡單物件可能過於繁重。'],
  ['Prototype', '原型', 'creational', '從既有物件複製，產生新的實例。', '當初始化成本高，或想保留某個已設定好的物件作為起點。', '需要釐清深複製與淺複製，尤其是可變資料與循環參照。'],
  ['Singleton', '單例', 'creational', '限制實例數量，提供一致的存取點。', '當確實需要由單一實例協調同一份資源。', '共享狀態會增加測試與並行的難度，也可能隱藏依賴。'],
  ['Adapter', '轉接器', 'structural', '轉換介面，讓不同契約可以合作。', '當既有服務或資料格式與使用端需要的介面不相容。', '應清楚轉換語意；包裝無法自動補足原本缺少的能力。'],
  ['Bridge', '橋接', 'structural', '分開抽象與實作，讓兩個維度獨立變化。', '當兩個變化維度若使用繼承，會產生大量組合類別。', '需要先辨認真正獨立的維度，否則只會增加間接層。'],
  ['Composite', '組合', 'structural', '用相同介面處理單一物件與樹狀群組。', '當資料形成部分與整體的階層，且希望統一操作。', '共同介面可能難以表達葉節點與容器各自的限制。'],
  ['Decorator', '裝飾者', 'structural', '透過逐層包裝，動態疊加物件能力。', '當需要自由組合額外行為，又不想建立所有組合的子類別。', '包裝順序會影響行為，很多層也會增加除錯成本。'],
  ['Facade', '外觀', 'structural', '替複雜子系統提供簡單的入口。', '當使用者只需要少數常用操作，不該理解全部內部細節。', '避免入口持續累積職責，最後成為新的龐大類別。'],
  ['Flyweight', '享元', 'structural', '共用不變資料，減少大量物件的重複成本。', '當大量物件具有相同的內在狀態，可將變動狀態移到外部。', '節省記憶體的同時，會增加狀態分離與查找的複雜度。'],
  ['Proxy', '代理', 'structural', '保留原有介面，控制對真實物件的存取。', '當需要延遲建立、存取檢查，或替遠端物件提供本地入口。', '額外的存取層可能隱藏延遲、失敗或快取一致性問題。'],
  ['Chain of Responsibility', '責任鏈', 'behavioral', '沿處理者鏈傳遞請求，直到有人接手。', '當多個處理者都有可能負責，且不想讓發送者固定依賴某一個。', '順序與終止條件必須清楚，也要處理無人接手的情況。'],
  ['Command', '命令', 'behavioral', '將一次請求封裝成可傳遞的物件。', '當操作需要排程、記錄、佇列或支援撤銷。', '會增加命令類別；撤銷也需要額外設計狀態恢復方式。'],
  ['Iterator', '迭代器', 'behavioral', '逐一存取集合元素，隱藏內部結構。', '當同一集合需要不同遍歷方式，或不希望公開儲存細節。', '遍歷期間的集合變動與迭代狀態需要明確約定。'],
  ['Mediator', '中介者', 'behavioral', '集中協調互動，減少物件彼此直接依賴。', '當多個物件交互關係複雜，且可以抽出清楚的協調角色。', '中介者容易膨脹；需要限制它只負責協調，不承包所有細節。'],
  ['Memento', '備忘錄', 'behavioral', '保存狀態快照，在需要時還原。', '當需要復原、回到檢查點，同時保留物件的封裝邊界。', '快照可能佔用大量空間，也要考量版本與儲存成本。'],
  ['Observer', '觀察者', 'behavioral', '狀態改變時，通知已訂閱的對象。', '當一個事件需要讓多個接收者各自反應。', '要管理取消訂閱、通知順序，以及事件連鎖的副作用。'],
  ['State', '狀態', 'behavioral', '讓行為隨內部狀態改變。', '當物件在不同生命週期階段有不同操作與轉移規則。', '狀態類別會增加，轉移規則要有清晰且一致的歸屬。'],
  ['Strategy', '策略', 'behavioral', '封裝可互換的演算法，以組合選擇行為。', '當同一任務存在多種做法，需要獨立更換整套流程。', '呼叫端仍需選擇合適策略；條件判斷被集中而非憑空消失。'],
  ['Template Method', '樣板方法', 'behavioral', '固定演算法骨架，讓子類別改寫部分步驟。', '當各流程的步驟順序相同，只有部分實作不同。', '基於繼承，子類別會受到骨架限制；整套演算法的切換可考慮 Strategy。'],
  ['Visitor', '訪問者', 'behavioral', '將操作抽出，為穩定物件結構加入新行為。', '當物件種類相對固定，卻經常要增加跨種類的操作。', '新增物件種類可能要修改所有訪問者，也可能暴露內部資料。'],
  ['Interpreter', '直譯器', 'behavioral', '以物件表示文法規則，解釋簡單語言。', '當需要表達小型且穩定的規則語言或運算式。', '複雜文法會導致大量類別，較適合使用專門的解析工具。']
];
const categoryNames = {creational:'創建模式',structural:'結構模式',behavioral:'行為模式'};
let filter = 'all';
function renderPatterns() {
  const query = $('#pattern-search').value.trim().toLowerCase();
  const list = patterns.map((p, index) => ({p, index})).filter(({p}) => (filter === 'all' || p[2] === filter) && (p.join(' ') + categoryNames[p[2]]).toLowerCase().includes(query));
  $('#pattern-grid').innerHTML = list.map(({p,index}) => `<button class="pattern-card" data-category="${p[2]}" data-pattern="${index}" aria-haspopup="dialog"><span class="pattern-type">${categoryNames[p[2]]} / ${p[2].toUpperCase()}</span><strong>${p[0]}</strong><span>${p[1]}</span><p>${p[3]}</p><span class="pattern-arrow" aria-hidden="true">↗</span></button>`).join('');
  $('#result-count').textContent = `${list.length} 個模式`;
  $('#empty-search').hidden = list.length > 0;
}
$$('[data-filter]').forEach(button => button.addEventListener('click', () => { filter = button.dataset.filter; $$('[data-filter]').forEach(b => { b.classList.toggle('selected', b === button); b.setAttribute('aria-pressed', b === button); }); renderPatterns(); }));
$('#pattern-search').addEventListener('input', renderPatterns);
$('#pattern-grid').addEventListener('click', event => {
  const button = event.target.closest('[data-pattern]'); if (!button) return;
  const p = patterns[Number(button.dataset.pattern)];
  $('#dialog-content').innerHTML = `<span class="dialog-type">${categoryNames[p[2]]} / ${p[2].toUpperCase()}</span><h2 id="dialog-title">${p[0]}</h2><h3>${p[1]}</h3><p>${p[3]}</p><div class="dialog-hint"><strong>什麼時候值得考慮？</strong><p>${p[4]}</p><strong>需要一起考量的代價</strong><p>${p[5]}</p></div>`;
  $('#pattern-dialog').showModal();
});
$('.dialog-close').addEventListener('click', () => $('#pattern-dialog').close());
$('.dialog-done').addEventListener('click', () => $('#pattern-dialog').close());
$('#pattern-dialog').addEventListener('click', event => { if (event.target !== $('#pattern-dialog')) return; const r = event.target.getBoundingClientRect(); if (event.clientX < r.left || event.clientX > r.right || event.clientY < r.top || event.clientY > r.bottom) event.target.close(); });
renderPatterns();

$$('[data-branch]').forEach(button => button.addEventListener('click', () => {
  const before = button.dataset.branch === 'before';
  $$('[data-branch]').forEach(b => b.setAttribute('aria-pressed', b === button));
  $('#branch-image').src = `web/assets/${before ? 'branching' : 'branching-refactored'}.svg`;
  $('#branch-image').alt = before ? '三層條件分支形成八種可能的路徑' : '在入口選擇策略，委派給三個獨立封裝的行為';
  $('#branch-caption').textContent = before ? '三個獨立布林條件，最多形成 2³ = 8 種組合。判斷散落各處，閱讀成本也跟著增加。' : '在入口選擇適合的策略，讓每個實作專注自己的流程。圖示三種代表性策略，並非把八種條件組合直接縮成三種。';
}));
const relationContent = {
  chain: ['behavior-chain', '行為依序跨越物件 A 與物件 B 呼叫，形成相依鏈', '行為彼此呼叫，流程直接，但鏈條變長後，理解一個行為可能得追蹤更多步驟與物件。'],
  objects: ['object-relationships', '物件 A 與物件 B 保有各自職責，透過共享契約協作', '從物件的職責出發，各自協調內部行為，再以明確契約互動。集中協調有助理解全局，也要避免物件承擔過多職責。'],
  coupling: ['object-coupling', '物件 A 與 C 高度相依，A 與 B 少量相依，D 相對獨立', '關係越緊密，變更越可能互相影響。圖中的重疊呈現原筆記的比喻；實際耦合仍需檢查共享資料、介面與變更傳播。']
};
$$('[data-relation]').forEach(button => button.addEventListener('click', () => { const r = relationContent[button.dataset.relation]; $$('[data-relation]').forEach(b => b.setAttribute('aria-pressed', b === button)); $('#relationship-image').src = `web/assets/${r[0]}.svg`; $('#relationship-image').alt = r[1]; $('#relationship-caption').textContent = r[2]; }));

const stages = [
  ['起始物件','Object','需求單純時，一個物件完成固定行為即可。先讓職責清楚，保留最少必要結構。'],
  ['種類增加','Factory','建立的物件種類變多，把建立決策移到工廠。使用端透過共同契約合作。'],
  ['骨架固定','Template','流程順序一致，但部分步驟不同。以樣板方法固定骨架，由子類別實作變動步驟。'],
  ['流程替換','Strategy','同一個任務有不同演算法。物件以組合持有策略，讓整套行為可以被替換。'],
  ['獨立維度','Bridge','物件的抽象與行為實作需要分別擴展。用橋接把兩個維度拆開，減少組合類別。'],
  ['協作增加','Mediator','多個物件的互動變得複雜。由中介者協調，讓參與者專注各自的行為。']
];
$('.evolution-steps').innerHTML = stages.map((s,i) => `<button data-stage="${i}" aria-pressed="${i === 0}">${String(i+1).padStart(2,'0')} ${s[0]}<span>${s[1]}</span></button>`).join('');
function svgNode(x,y,w,label,sub='',fill='#fff') { return `<g><rect x="${x}" y="${y}" width="${w}" height="65" rx="11" fill="${fill}" stroke="#bddbd0"/><text x="${x+w/2}" y="${y+28}" text-anchor="middle" fill="#20243b" font-size="15">${label}</text><text x="${x+w/2}" y="${y+49}" text-anchor="middle" fill="#86967a" font-size="10">${sub}</text></g>`; }
function edge(x1,y1,x2,y2) { return `<path d="M${x1} ${y1} L${x2} ${y2}" fill="none" stroke="#4e9c83" stroke-width="1.6" marker-end="url(#evo-arrow)"/>`; }
function showStage(i) {
  let body = '';
  if(i===0) body = edge(340,160,520,160)+svgNode(160,128,180,'使用者物件','清楚的職責','#dff1e9')+svgNode(520,128,180,'固定行為','完成目前需要的事');
  if(i===1) body = edge(275,160,390,88)+edge(275,160,390,228)+edge(550,88,640,160)+edge(550,228,640,160)+svgNode(100,128,175,'建立入口','Factory','#dff1e9')+svgNode(390,55,160,'一般使用者','具體類別 A')+svgNode(390,195,160,'管理使用者','具體類別 B')+svgNode(640,128,165,'共同契約','使用端依賴抽象');
  if(i===2) body = `<rect x="100" y="68" width="700" height="183" rx="18" fill="#e4f2ed" stroke="#b7c8a7"/><text x="125" y="99" font-size="13" fill="#648054">固定的演算法骨架 · Template Method</text>`+edge(300,169,363,169)+edge(537,169,600,169)+svgNode(125,136,175,'共同準備','固定步驟')+svgNode(363,136,174,'變動步驟','由子類別覆寫','#ffedb0')+svgNode(600,136,175,'共同收尾','固定步驟');
  if(i===3) body = edge(320,160,540,78)+edge(320,160,540,168)+edge(320,160,540,258)+svgNode(130,128,190,'使用者物件','持有一個策略介面','#dff1e9')+svgNode(540,45,220,'策略 A','整套演算法 A')+svgNode(540,135,220,'策略 B','整套演算法 B')+svgNode(540,225,220,'策略 C','整套演算法 C');
  if(i===4) body = `<rect x="65" y="44" width="325" height="245" rx="16" fill="#e1f1e9"/><rect x="510" y="44" width="325" height="245" rx="16" fill="#fff0c6"/><text x="90" y="77" font-size="14" fill="#6e815c">抽象維度 · 獨立擴展</text><text x="535" y="77" font-size="14" fill="#8e8566">實作維度 · 獨立擴展</text>`+edge(350,160,550,160)+svgNode(105,104,245,'使用者抽象','透過實作介面委派','#fff')+svgNode(105,202,245,'不同使用者','延伸抽象端')+svgNode(550,104,245,'行為實作介面','Bridge','#fff')+svgNode(550,202,245,'不同實作','擴充實作端');
  if(i===5) body = edge(345,161,265,78)+edge(345,161,265,251)+edge(555,161,635,78)+edge(555,161,635,251)+svgNode(345,128,210,'中介者','集中協調互動','#d5eee3')+svgNode(75,45,190,'參與物件 A','各自完成職責')+svgNode(75,218,190,'參與物件 B','各自完成職責')+svgNode(635,45,190,'參與物件 C','各自完成職責')+svgNode(635,218,190,'參與物件 D','各自完成職責');
  $('#evolution-diagram').innerHTML = `<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 900 330" role="img" aria-labelledby="evo-title"><title id="evo-title">${stages[i][0]}：${stages[i][2]}</title><defs><marker id="evo-arrow" viewBox="0 0 10 10" refX="9" refY="5" markerWidth="6" markerHeight="6" orient="auto-start-reverse"><path d="M0 0 L10 5 L0 10" fill="#4e9c83"/></marker></defs><g font-family="Noto Sans TC,system-ui,sans-serif">${body}</g></svg>`;
  $('#evolution-caption').textContent = stages[i][2];
  $$('[data-stage]').forEach((b,index) => b.setAttribute('aria-pressed', index === i));
}
$$('[data-stage]').forEach(button => button.addEventListener('click', () => showStage(Number(button.dataset.stage))));
showStage(0);

// Keep diagram labels readable on narrow screens; only the figure viewport scrolls.
$$('.diagram-box > img').forEach(img => {
  const viewport = document.createElement('div');
  viewport.className = 'diagram-scroll';
  viewport.tabIndex = 0;
  viewport.setAttribute('role', 'region');
  viewport.setAttribute('aria-label', '概念圖，窄螢幕可左右捲動');
  img.before(viewport);
  viewport.append(img);
});
$('#evolution-diagram').classList.add('diagram-scroll');
$('#evolution-diagram').tabIndex = 0;
$('#evolution-diagram').setAttribute('role', 'region');
$('#evolution-diagram').setAttribute('aria-label', '設計演進圖，窄螢幕可左右捲動');
$$('.diagram-box').forEach(figure => {
  const hint = document.createElement('p');
  hint.className = 'diagram-scroll-hint';
  hint.textContent = '← 左右滑動，閱讀完整圖解 →';
  figure.prepend(hint);
});

const menu = $('.menu-button');
function closeMenu() { $('#sidebar').classList.remove('open'); menu.setAttribute('aria-expanded','false'); menu.setAttribute('aria-label','開啟章節導覽'); $('#sidebar').inert = innerWidth <= 850; }
menu.addEventListener('click', () => { const open = $('#sidebar').classList.toggle('open'); menu.setAttribute('aria-expanded', open); menu.setAttribute('aria-label', open ? '關閉章節導覽' : '開啟章節導覽'); $('#sidebar').inert = !open && innerWidth <= 850; });
closeMenu();
$$('.nav-link').forEach(link => link.addEventListener('click', closeMenu));
document.addEventListener('click', event => { if (!event.target.closest('#sidebar, .menu-button')) closeMenu(); });
document.addEventListener('keydown', event => { if (event.key === 'Escape') closeMenu(); if (event.key === '/' && !event.target.matches('input,textarea,[contenteditable]') && !$('#pattern-dialog').open) { event.preventDefault(); $('#pattern-search').scrollIntoView({block:'center'}); $('#pattern-search').focus({preventScroll:true}); } });
function syncNavigation() {
  const position = window.scrollY + 150;
  const sections = $$('.observed');
  const current = sections.filter(s => s.offsetTop <= position).at(-1) || sections[0];
  $$('.nav-link').forEach(link => { const active = link.hash === '#' + current.id; link.classList.toggle('active',active); if(active) link.setAttribute('aria-current','location'); else link.removeAttribute('aria-current'); });
}
let scheduled = false;
window.addEventListener('scroll', () => { if (!scheduled) { scheduled = true; requestAnimationFrame(() => { syncNavigation(); scheduled = false; }); } }, {passive:true});
window.addEventListener('resize', () => { if(innerWidth > 850) closeMenu(); $('#sidebar').inert = innerWidth <= 850 && !$('#sidebar').classList.contains('open'); syncNavigation(); });
window.addEventListener('load', syncNavigation);
syncNavigation();
