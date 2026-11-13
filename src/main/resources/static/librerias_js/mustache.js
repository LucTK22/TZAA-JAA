(function(window){
    function render(template, data) {
        var result = template;

        result = result.replace(/{{#\.}}([\s\S]*?){{\/\.}}/g, function(_, block) {
            if (!Array.isArray(data)) return "";
            return data.map(function(item) {
                return render(block, item);
            }).join("");
        });

        result = result.replace(/{{\s*([a-zA-Z0-9_]+)\s*}}/g, function(_, key) {
            return data && data[key] != null ? String(data[key]) : "";
        });

        return result;
    }

    window.Mustache = {
        render: render
    };
})(window);
