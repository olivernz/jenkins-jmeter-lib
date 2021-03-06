import nz.co.breakpoint.jenkins.JmeterPlotter

def call(parameters = [:]) {
    def inputs = findFiles(glob: parameters.inputs ?: '**/*.csv')
    def output = parameters.output ?: 'index.html'
    def type = parameters.type ?: 'scatter'
    def html = JmeterPlotter.generateHtml(inputs, type.toLowerCase(), parameters.hover ?: '')
    writeFile text: html, file: output
}
