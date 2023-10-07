//import { TextureLoader } from 'three/src/loaders/TextureLoader'
// import {GLTFLoader} from "./three.js-r132/examples/jsm/loaders/GLTFLoader.js";
let scene, camera, light;
let scene1, camera1, renderer1;
let mainscene, maincamera;
let cubes = [];
let zerox = [];
let crox = [];
let cubes1 = [];
let values = [9];
let isDragging = false;
let previousMousePosition = { x: 0, y: 0 };
const NUM_CUBES = 3;
let mouseX = 0, mouseY = 0;
const windowHalfX = window.innerWidth / 2;
const windowHalfY = window.innerHeight / 2;
let count=0, ind=0;
let stars;
let starGeo;
let khelajitsi=300;
let khelajitaranimation=1;

let mainboardflag=1;

function init() {
    initformality();
	//const orbit = new OrbitControls(camera,renderer.domElement);
	background();

    ninecubes();
	
    addlight();
	
	document.addEventListener('mousedown', onMouseDown);
    document.addEventListener('mousemove', onMouseMove);
    document.addEventListener('mouseup', onMouseUp);
	document.addEventListener('click', onMouseClick);
    scene1 = new THREE.Scene();
    camera1 = new THREE.PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000);

    renderer1 = new THREE.WebGLRenderer();
    renderer1.shadowMap.enabled=true;
    renderer1.setSize(window.innerWidth, window.innerHeight);
    document.body.appendChild(renderer1.domElement);
	// var geometry = new THREE.BoxGeometry(1, 1, 1);
	// var material = new THREE.MeshBasicMaterial( { color: 0xffffff } );
	// mesh = new THREE.Mesh(geometry, material);
	// scene1.add(mesh);

    const pic = new THREE.TextureLoader();
    scene1.background = pic.load('https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Tic_tac_toe.svg/1200px-Tic_tac_toe.svg.png');
    
    mainboard();
    //gameboard();
}

function initformality() {
    scene = new THREE.Scene();
    camera = new THREE.PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000);
    //renderer1 = new THREE.WebGLRenderer();
    // renderer1.shadowMap.enabled=true;
    // renderer1.setSize(window.innerWidth, window.innerHeight);
    // document.body.appendChild(renderer1.domElement);
}

function background() {
    // const x = new THREE.BoxGeometry(10, 10, 5);
	// const y = new THREE.MeshLambertMaterial({ color: 0xfff000 });
	// const z = new THREE.Mesh(x, y);
	// z.position.z=-3;
	// z.position.x=0;
	// z.position.y=0;
    // z.receiveShadow = true;
	// scene.add(z);
    //---

    let points=[];
    for(let i=0;i<6000;i++) {
        let star = new THREE.Vector3(
            Math.random() * 600 - 300,
            Math.random() * 600 - 300,
            Math.random() * 600 - 300
        );
        points.push(star);
    }
    starGeo = new THREE.BufferGeometry().setFromPoints(points);
    let sprite = new THREE.TextureLoader().load( 'https://media.istockphoto.com/id/1412432705/photo/golf-ball-with-strong-side-light.jpg?s=612x612&w=0&k=20&c=Fvfuk7Y3Ci1c1jkrJKhcHXzkiQGwXp9ajVtOd4KdZ3Y=' );
    let starMaterial = new THREE.PointsMaterial({
    color: 0xaaaaaa,
    size: 0.7,
    map: sprite
    });
    //scene.add(line)
    // const pic = new THREE.TextureLoader();
    // scene.background = pic.load('https://images.unsplash.com/photo-1472214103451-9374bd1c798e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cGljfGVufDB8fDB8fHww&w=1000&q=80');
    stars = new THREE.Points(starGeo,starMaterial);
    // stars.rotateX(0.1);
    scene.add(stars);
    
    // pic.rec
    // scene.add(pic);
    // const loader = new GLTFLoader();

    // loader.load( 'E:\TTT\src\adamHead\adamHead.gltf', function ( gltf ) {

    //     scene.add( gltf.scene );

    // }, undefined, function ( error ) {

    //     console.error( error );

    // } );
}

function ninecubes() {
    for (let i = 0; i < NUM_CUBES; i++) {
		for (let j = 0; j < NUM_CUBES; j++) {
			values[i*3+j]=0;
			const cubeGeometry = new THREE.BoxGeometry(0.9, 0.9, 0.9);
			const cubeMaterial = new THREE.MeshLambertMaterial({ color: 0xffffff });
			const cube = new THREE.Mesh(cubeGeometry, cubeMaterial);

            const zeroGeometry = new THREE.OctahedronGeometry(0.5, 0);
			const zeroMaterial = new THREE.MeshLambertMaterial({ color: 0xfff000 });
			const zero = new THREE.Mesh(zeroGeometry, zeroMaterial);

            const croGeometry = new THREE.TorusGeometry(0.4, 0.12, 100, 100);
			const croMaterial = new THREE.MeshLambertMaterial({ color: 0xff0000 });
			const cro = new THREE.Mesh(croGeometry, croMaterial);


			cube.position.x=i-1;
			cube.position.y=j-1;
			cube.position.z=0;

            zero.position.x=i-1;
			zero.position.y=j-1;
			zero.position.z=100;

            cro.position.x=i-1;
			cro.position.y=j-1;
			cro.position.z=100;


            cube.castShadow = true;
            zero.castShadow = true;
            cro.castShadow = true;


			cubes.push(cube);
            zerox.push(zero);
            crox.push(cro);

			scene.add(cube);
            scene.add(zero);
            scene.add(cro);
		}
    }
}

function addlight() {
    light = new THREE.DirectionalLight(0xc4c4c4,10);
	light.position.set(10,10,10);
    light.castShadow = true;
	scene.add(light);

    // const lighthelper = new THREE.DirectionalLightHelper(light , 5);
    // scene.add(lighthelper);
	
	// let xx=new THREE.AxesHelper(5);
    // scene.add(xx);
}

function gameboard() {
	
	camera.position.z = 5;
    mainscene = scene;
    maincamera = camera;
	//orbit.update();
	render1();
}
let mesh;
function mainboard() {
	
	// document.addEventListener('mousedown', onMouseDown);
    // document.addEventListener('mousemove', onMouseMove);
    // document.addEventListener('mouseup', onMouseUp);
	// document.addEventListener('click', onMouseClick);
	
	camera1.position.z = 5;
    mainscene = scene1;
    maincamera = camera1;
	render1();
}

function onMouseClick() {

    if(mainboardflag == 1) {
        //mesh.material.color.set(getRandomColor());
        mainboardflag = 2;
        mainscene = scene;
        maincamera = camera;
        khelajitsi = 300;
        cubes[4].position.z=-30;
        gameboard();
        return;
    }

	actionofcubes();
	
	if(gameover()) {
        khelajitsi = 300;
		let tempcolor=0Xffffff;
		cubes.forEach(cube => {
            cube.position.z=0;
			cube.material.color.set(tempcolor);
		});
        zerox.forEach(zero => {
            zero.position.z=100;
			//zero.material.color.set(tempcolor);
		});
        crox.forEach(cro => {
            cro.position.z=100;
			//zero.material.color.set(tempcolor);
		});

        //animationofblocks();
        
		count = 0;
		ind = 0;
		for(let i = 0; i < 9; i++) {
			values[i] = 0;
		}
	}
	
}

function actionofcubes() {
	mouseX = (event.clientX - windowHalfX) / 100;
    mouseY = -(event.clientY - windowHalfY) / 100;
    console.log(mouseX);
    console.log(mouseY);
	for (let i=0 ; i<9 ; i++) {
		let X=cubes[i].position.x-mouseX;
		let Y=cubes[i].position.y-mouseY;
		if(X<0) {
			X*=-1;
		}
		if(Y<0) {
			Y*=-1;
		}
		if(X<=0.5&&Y<=0.5&&values[i]==0) {
			cubes[i].material.color.set(getColor());
            if(count%2==1) {
                crox[i].position.z=0;
                cubes[i].position.z=100;
                zerox[i].position.z=100;
            }
            else {
                crox[i].position.z=100;
                cubes[i].position.z=100;
                zerox[i].position.z=0;
            }
			values[i]=count%2+1;
			//cubes[i].position.z=cubes[i].position.z+1;
		}
	}
}

function gameover() {
	let flag = 0;
	for (let i=0 ; i<3 ; i++) {
		if((values[i]==1&&values[i+3]==1&&values[i+6]==1)||(values[i]==2&&values[i+3]==2&&values[i+6]==2)){
			flag=1;
		}
	}
	for (let i=0 ; i<9 ; i+=3) {
		if((values[i]==1&&values[i+1]==1&&values[i+2]==1)||(values[i]==2&&values[i+1]==2&&values[i+2]==2)){
			flag=1;
		}
	}
	if((values[0]==1&&values[4]==1&&values[8]==1)||(values[0]==2&&values[4]==2&&values[8]==2)){
		flag=1;
	}
	if((values[2]==1&&values[4]==1&&values[6]==1)||(values[2]==2&&values[4]==2&&values[6]==2)){
		flag=1;
	}
	return flag;
}

function onMouseDown(event) {
    isDragging = true;
    previousMousePosition = { x: event.clientX, y: event.clientY };
    console.log(previousMousePosition.x);
    console.log(previousMousePosition.y);
}

function onMouseMove(event) {
    if (isDragging) {
		const deltaMove = {
			x: event.clientX - previousMousePosition.x,
			y: event.clientY - previousMousePosition.y
		};
		
		cubes.forEach(cube => {
			cube.rotation.x += toRadians(deltaMove.y * 1);
			cube.rotation.y += toRadians(deltaMove.x * 1);
		});

        zerox.forEach(zero => {
			zero.rotation.x += toRadians(deltaMove.y * 1);
			zero.rotation.y += toRadians(deltaMove.x * 1);
		});

        crox.forEach(cro => {
			cro.rotation.x += toRadians(deltaMove.y * 1);
			cro.rotation.y += toRadians(deltaMove.x * 1);
		});
		
		previousMousePosition = { x: event.clientX, y: event.clientY };
        
    }
}

function onMouseUp() {
    isDragging = false;
}

function toRadians(degrees) {
    return degrees * (Math.PI / 180);
}

// function render() {
// 	//camera.position.z=camera.position.z+0.1;
//     renderer.render(mainscene, camera);
//     requestAnimationFrame(render);
// }
let tempX = [9];
let tempY = [9];
let changelightpos = 0.03;
function render1() {
    if(light.position.x >= 10) {
        changelightpos = -0.03;
    }
    if(light.position.x <= -10) {
        changelightpos = 0.03;
    }
    light.position.x+=changelightpos;
    light.position.y+=changelightpos;
    console.log(light.position.x);
    console.log(light.position.y);
    if(khelajitsi == 300) {
        tempX[0]=tempX[1]=tempX[2]=-4;
        tempX[3]=tempX[4]=tempX[5]=0;
        tempX[6]=tempX[7]=tempX[8]=4;
        tempY[0]=tempY[3]=tempY[6]=-4;
        tempY[1]=tempY[4]=tempY[7]=0;
        tempY[2]=tempY[5]=tempY[8]=4;
        cubes[4].position.z=-30;
        khelajitaranimation = 1;
    }
    if(khelajitsi <= 0) {
        if(khelajitaranimation == 1) {
            for(let j=0; j<9; j++) {
                cubes[j].rotation.x=0;
                cubes[j].rotation.y=0;
                cubes[j].rotation.z=0;
            }
        }
        khelajitaranimation = 0;
    }

    //console.log(khelajitsi);

    if(khelajitaranimation == 1) {
        let change=0.01;
        for(let j=0; j<9; j++)
        {
            if(j == 4) {
                cubes[4].position.z+=0.1;
                continue;
            }
            if(tempX[j]<0) {
                tempX[j]+=change;
            }
            if(tempY[j]<0) {
                tempY[j]+=change;
            }
            if(tempX[j]>0) {
                tempX[j]-=change;
            }
            if(tempY[j]>0) {
                tempY[j]-=change;
            }
            //console.log(tempX[j]);
            cubes[j].position.x=tempX[j];
            cubes[j].position.y=tempY[j];
            cubes[j].rotation.x+=3/(Math.acos(-1)*180);
            cubes[j].rotation.y+=3/(Math.acos(-1)*180);
            cubes[j].rotation.z+=3/(Math.acos(-1)*180);
        }
    }

    khelajitsi--;
    if(mainboardflag == 2) {
        stars.rotateX(0.0001);
        stars.rotateY(0.0002);
    }
    renderer1.render(mainscene, maincamera);
    requestAnimationFrame(render1);
}

function getRandomPosition() {
    return (Math.random() - 0.5) * 10;
}

function getRandomColor() {
    return Math.random() * 0xffffff;
}

function getColor() {
	count++;
    if(count%2==0){
		return 0xfff000;
	}
	return 0xff0000;
}

init();

