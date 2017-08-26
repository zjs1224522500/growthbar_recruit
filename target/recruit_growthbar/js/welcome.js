T    = "青春有梦   文字 爱情 旅行   九月成电相遇   我们侧耳倾听你的故事   ";
I    = 0;
o    = new Array();
xm   = -1000;
ym   = -1000;
rad  = 80;
dim  = 200;
W    = 0;
H    = 0;
NX   = 14;
NY   = 14;
var nx;
var ny;

document.onmousemove = function(e){
	if (window.event) e = window.event;
	xm = (e.x || e.clientX) - (nx  * .5) + dim * .5;
	ym = (e.y || e.clientY) - (ny * .5) + dim * .5;
}

function resize() {
	nx = document.body.offsetWidth;
	ny = document.body.offsetHeight;
}
onresize = resize;

function CObj(N,i,j,c){
	this.obj = document.createElement("span");
	this.obj.innerHTML = c;
	DOOT.appendChild(this.obj);
	this.N    = N;
	this.To   = 16;
	this.x0   = i*2*W;
	this.y0   = j*2*H;
	this.anim = true;

	this.mainloop = function(){
		with (this) {
 			dx   = xm - x0;
			dy   = ym - y0;
			dist = Math.sqrt(dx * dx + dy * dy);
			if (dist < rad) {
				anim = true;
				M    = Math.cos(.5 * Math.PI * Math.abs(dist / rad));
				c    = Math.round(230 + M * 171);
				with(obj.style){
					left     = x0 - dx * M;
					top      = y0 - dy * M;
					zIndex   = Math.round(100 + M);
					fontSize = 8 + M * W * 2;
					color    = "RGB("+c+","+c+","+c+")";
				}
			} else {
				if(anim){
					with(obj.style){
						left     = x0;
						top      = y0;
						zIndex   = 0;
						fontSize = 8;
						color    = "RGB(88,88,88)";
					}
				anim = false;
				}
			}
		}
	}
}
function run(){
	for(i in o)o[i].mainloop();
	setTimeout(run,16);
}

onload = function (){
	DOOT = document.getElementById("doot");
	with(DOOT.style){
		left = -dim/2;
		top  = -dim/2;
		width = dim;
		height = dim;
	}
	resize();
	W = (dim  / NX) / 2;
	H = (dim / NY) / 2;
	K = 0;
	for(var j=0;j<NY;j++){
		for(var i=0;i<NX;i++){
			c=T.charAt((I++)%T.length).toUpperCase();
			if(c==" ")c="·";
			o[K] = new CObj(K++,i,j,c);
		}
	}
	run();
}