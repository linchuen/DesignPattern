import { writeFile } from 'node:fs/promises';
// A standalone redraw of 設計模式思考示意圖.jpg. These are thinking perspectives, not GoF categories.
const ink='#20243b', muted='#6f777d', teal='#4c9f86', yellow='#ffce57', coral='#f38b70';
const t=(x,y,s,size=16,color=ink,anchor='start')=>`<text x="${x}" y="${y}" font-size="${size}" fill="${color}" text-anchor="${anchor}">${s}</text>`;
const box=(x,y,w,label,fill='#fff',h=32)=>`<rect x="${x}" y="${y}" width="${w}" height="${h}" rx="8" fill="${fill}" stroke="#c9dcd4"/>${t(x+w/2,y+h/2+5,label,13,ink,'middle')}`;
const arrow=(x,y,x2,y2)=>`<path d="M${x} ${y} L${x2} ${y2}" stroke="${teal}" stroke-width="1.5" marker-end="url(#arrow)" fill="none"/>`;
const cards=[
 ['Factory','工廠方法','把建立的決策，放在合適的入口。','factory'],
 ['Builder','建造者','把複雜物件，拆成可組裝的步驟。','builder'],
 ['State','狀態','物件的行為，隨內部狀態改變。','state'],
 ['Proxy','代理','透過相同介面，控制物件的存取。','proxy'],
 ['Template Method','樣板方法','固定流程骨架，覆寫變動步驟。','template'],
 ['Strategy','策略','用共同介面，替換整套演算法。','strategy'],
 ['Adapter','轉接器','轉換不相容的介面，接上既有能力。','adapter'],
 ['Chain of Responsibility','責任鏈','沿處理者傳遞，直到有人接手。','chain'],
 ['Bridge','橋接','抽象與實作，沿兩個維度獨立擴展。','bridge'],
 ['Decorator','裝飾者','逐層包裝，為物件疊加能力。','decorator'],
 ['Mediator','中介者','集中協調互動，減少彼此直接相依。','mediator'],
 ['Composite','組合','以共同介面，操作群組與單一物件。','composite']
];
function mini(kind,x,y){
 let s='';
 if(kind==='factory'||kind==='strategy'){s=arrow(x+105,y+34,x+205,y+12)+arrow(x+105,y+34,x+205,y+58)+box(x+5,y+18,100,kind==='factory'?'建立入口':'策略介面','#e1f1eb')+box(x+205,y-4,98,kind==='factory'?'物件 A':'策略 A')+box(x+205,y+42,98,kind==='factory'?'物件 B':'策略 B');}
 if(kind==='builder'){s=arrow(x+79,y+34,x+108,y+34)+arrow(x+187,y+34,x+217,y+34)+box(x,y+18,79,'步驟 1')+box(x+108,y+18,79,'步驟 2')+box(x+217,y+18,87,'完整物件','#fff0bf');}
 if(kind==='state'){s=box(x,y-6,305,'','#e1f1eb',88)+t(x+152,y+15,'物件持有目前狀態',12,muted,'middle')+arrow(x+85,y+48,x+112,y+48)+arrow(x+195,y+48,x+223,y+48)+box(x+7,y+32,78,'狀態 A')+box(x+112,y+32,83,'狀態 B')+box(x+223,y+32,75,'狀態 C');}
 if(kind==='proxy'){s=arrow(x+80,y+34,x+110,y+34)+arrow(x+200,y+34,x+225,y+34)+box(x,y+18,80,'使用端')+box(x+110,y+18,90,'代理','#ffe3d9')+box(x+225,y+18,80,'物件');}
 if(kind==='template'){s=arrow(x+84,y+34,x+110,y+34)+arrow(x+194,y+34,x+220,y+34)+box(x,y+18,84,'共同步驟')+box(x+110,y+18,84,'覆寫步驟','#fff0bf')+box(x+220,y+18,84,'共同收尾');}
 if(kind==='adapter'){s=arrow(x+83,y+34,x+109,y+34)+arrow(x+195,y+34,x+221,y+34)+box(x,y+18,83,'介面 A')+box(x+109,y+18,86,'轉接器','#fff0bf')+box(x+221,y+18,83,'介面 B');}
 if(kind==='chain'){s=arrow(x+84,y+34,x+110,y+34)+arrow(x+194,y+34,x+220,y+34)+box(x,y+18,84,'處理者 1')+box(x+110,y+18,84,'處理者 2')+box(x+220,y+18,84,'處理者 3','#fff0bf');}
 if(kind==='bridge'){s=arrow(x+113,y+34,x+193,y+34)+box(x,y+18,113,'抽象維度','#e1f1eb')+box(x+193,y+18,112,'實作維度','#fff0bf')+t(x+57,y+76,'可獨立擴展',11,muted,'middle')+t(x+249,y+76,'可獨立擴展',11,muted,'middle');}
 if(kind==='decorator'){s=box(x,y-8,305,'','#ffe3d9',94)+t(x+12,y+10,'外層裝飾',11,muted)+box(x+35,y+18,235,'','#fff0bf',61)+t(x+47,y+35,'內層裝飾',11,muted)+box(x+75,y+43,155,'原始物件');}
 if(kind==='mediator'){s=arrow(x+92,y+10,x+115,y+32)+arrow(x+92,y+65,x+115,y+42)+arrow(x+193,y+32,x+215,y+10)+arrow(x+193,y+42,x+215,y+65)+box(x,y-5,92,'物件 A')+box(x,y+50,92,'物件 B')+box(x+115,y+22,78,'中介者','#e1f1eb')+box(x+215,y-5,90,'物件 C')+box(x+215,y+50,90,'物件 D');}
 if(kind==='composite'){s=arrow(x+152,y+18,x+66,y+57)+arrow(x+152,y+18,x+242,y+57)+box(x+102,y-10,100,'群組','#e1f1eb')+box(x+15,y+57,105,'子群組')+box(x+190,y+57,110,'單一物件');}
 return s;
}
let body=`<rect width="1200" height="1360" rx="24" fill="#fffdf8"/>${t(48,49,'DESIGN PATTERN / CONCEPT MAP',13,teal)}${t(48,96,'設計模式思考示意圖',34)}${t(48,131,'找出變化，並將其封裝。從物件出發，思考建立、行為與彼此的關係。',17,muted)}`;
body+=box(440,166,320,'物件：持有狀態，透過行為完成職責','#e1f1eb',48);
for(let c=0;c<3;c++){const x=38+c*380;const accent=[yellow,coral,teal][c];body+=arrow(600,214,x+182,253)+`<rect x="${x}" y="258" width="364" height="44" rx="12" fill="${accent}" fill-opacity=".26"/>`+t(x+182,287,['建立與存取','行為與流程','組合與協作'][c],19,ink,'middle');for(let r=0;r<4;r++){const y=322+r*228;const [en,zh,desc,kind]=cards[c*4+r];body+=`<rect x="${x}" y="${y}" width="364" height="212" rx="15" fill="#fff" stroke="#e7e4dc"/>`+t(x+20,y+31,en,en.length>22?18:21)+t(x+20,y+56,zh,14,teal)+mini(kind,x+28,y+81)+t(x+20,y+191,desc,14,muted);}}
body+=t(48,1275,'讀圖方式',16,ink)+t(48,1303,'箭頭表示建立、委派或流程方向；包覆表示組合。圖例為概念簡化，不是 UML 類別圖。',15,muted)+t(48,1330,'以上是思考視角，不是 GoF 分類，也不代表每個系統都需要套用全部模式。',15,muted);
const svg=`<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1200 1360" role="img" aria-labelledby="title desc"><title id="title">設計模式思考示意圖：從物件出發的十二種模式關係</title><desc id="desc">建立與存取：Factory、Builder、State、Proxy。行為與流程：Template Method、Strategy、Adapter、Chain of Responsibility。組合與協作：Bridge、Decorator、Mediator、Composite。</desc><defs><marker id="arrow" viewBox="0 0 10 10" refX="9" refY="5" markerWidth="6" markerHeight="6" orient="auto"><path d="M0 0 L10 5 L0 10" fill="${teal}"/></marker></defs><g font-family="Noto Sans TC,Microsoft JhengHei,system-ui,sans-serif">${body}</g></svg>`;
await writeFile(new URL('./assets/design-pattern-map.svg',import.meta.url),svg);
console.log('Generated standalone design-pattern-map.svg');
