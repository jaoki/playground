var os = require('os');

/*
 * GET home page.
 */

exports.index = function(req, res){
  res.render('index', { title: 'Express', hostname : os.hostname() })
};
