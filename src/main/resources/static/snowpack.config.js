module.exports = {
  plugins: [
    [
      '@snowpack/plugin-sass'
    ],
  ],
  packageOptions: {
    knownEntrypoints: ['@hotwired/turbo', 'stimulus', 'bulma']
  },
  buildOptions: {
    out: "../resources/static"
  }
}
