module.exports = {
  optimize: {
    bundle: true,
    minify: true,
    target: 'es2015',
    entrypoints: [
      '../templates/city.html',
      '../templates/home.html',
      '../templates/add-city.html',
    ]
  },
  plugins: [
    [
      '@snowpack/plugin-sass',
      {
        compilerOptions: {
          loadPath: './node_modules',
        },
      }
    ]
  ],
  packageOptions: {
    knownEntrypoints: ['@hotwired/turbo', 'stimulus', 'bulma']
  },
  buildOptions: {
    out: '../../../target/classes/static'
  }
}
