console.log('Modules is loading...');
define(function(require){
    {{#modules}}
    require('{{scriptUrl}}');
    {{/modules}}
    return function () {
        return {
            modulesNames:{{{modulesNamesAsString}}},
            modules: {{{modulesAsJson}}}
        };
    };
});

function loadCss(url) {
    if (document.createStyleSheet) {
        document.createStyleSheet(url);
    } else {
        $('<link rel="stylesheet" type="text/less" href="' + url + '" />').appendTo('head');
    }
}

function loadJs(url) {
    $('<script type="text/javascript" src="' + url + '" />').appendTo('head');
}