/*
*
* Script para realizar o deploy da PWA no ftp do servidor
* Required: npm install ftp-deploy
*/

var FtpDeploy = require('ftp-deploy');
var ftpDeploy = new FtpDeploy();
 
var config = {
    username: "deploy@relig.me",
    password: "asdQWE123!@#", // optional, prompted if none given 
    host: "ftp.johntheo.com.br",
    port: 21,
    localRoot: __dirname + "/www",
    remoteRoot: "/home/johnt376/public_html/relig.me/app/",
    include: ['build/version.txt'],
    exclude: ['.git', '.idea', 'tmp/*', 'build/*']
}
    
ftpDeploy.deploy(config, function(err) {
    if (err) console.log(err)
    else console.log('finished');
});

ftpDeploy.on('uploading', function(data) {
    data.totalFileCount;       // total file count being transferred 
    data.transferredFileCount; // number of files transferred 
    data.percentComplete;      // percent as a number 1 - 100 
    data.filename;             // partial path with filename being uploaded 
});

ftpDeploy.on('uploaded', function(data) {
    console.log(data);         // same data as uploading event 
});

/* Continua o deploy se der erro
ftpDeploy.on('upload-error', function (data) {
    console.log(data.err); // data will also include filename, relativePath, and other goodies 
});
*/