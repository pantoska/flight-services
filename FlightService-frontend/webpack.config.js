var webpack = require('webpack');
var environment = process.env.NODE_ENV === 'production' ? 'production' : 'development';
var SERVER_URL = {
  production: JSON.stringify('http://localhost:8082'),
  development: JSON.stringify('http://localhost:8082')
}

module.exports = {
  entry: './src/index.js',
  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
        exclude: /node_modules/,
        use: ['babel-loader']
      },
      {
        test: /\.css$/,
        use: ['style-loader', 'css-loader']
      }
    ]
  },
  resolve: {
    extensions: ['*', '.js', '.jsx']
  },
  output: {
    path: __dirname + '/dist',
    publicPath: '/',
    filename: 'bundle.js'
  },
  devServer: {
    contentBase: './dist',
    historyApiFallback: {
      disableDotRule: true
    }
  },
  plugins: [
    new webpack.DefinePlugin({
      'SERVER_URL': SERVER_URL[environment]
    })
  ]
};

