import {instantiate} from './Noble.uninstantiated.mjs';

await wasmSetup;

await instantiate({skia: Module['asm']});
