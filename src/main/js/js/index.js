import * as turbo from '@hotwired/turbo'
import { Application } from '@hotwired/stimulus'
import { WeathersControlsController } from './WeathersControlsController'

console.log('Hotwire Demo App JS enabled');
turbo.setProgressBarDelay(5);

window.Stimulus = Application.start()
Stimulus.register("weather-controls", WeathersControlsController)
