var patient = ['Giri Kuncoro', 'Allie Meng', 'Abhishek Agarwal', 'Sarah Schuyler', 'Anke Wessels'];
var patientData = {
  'Giri Kuncoro': {age: 25, date: "12/13/1990"},
  'Allie Meng': {age: 21, date: "03/27/1994"},
  'Abhishek Agarwal': {age: 25, date: "12/13/1990"},
  'Anke Wessels': {age: 28, date: "07/17/1987"},
  'Sarah Schuyler': {age: 31, date: "4/5/1983"}
};
// console.log("Hey Whatssip");

// function init() {
//   console.log("Just for fun");
// }

// init();

// $.get("http://default-environment-yppgutk292.elasticbeanstalk.com/dossier/user/allUsers", function(data){
//   patientData = data; 
//   console.log(patientData); 
//   alert("Data Logged"); 
// });

//console.log("Nothing man You tell");

var App = React.createClass({
  getInitialState: function() {
    return { patientName: '', showPatient: false }
  },

  loadPatientData: function() {
    $.ajax({
      url: "http://default-environment-yppgutk292.elasticbeanstalk.com/dossier/user/allUsers",
      dataType: "json",
      success: function(data) {
        console.log(data);
      }.bind(this),
      error: function(xhr, status, err){
        console.log("This is an error");
      }.bind(this)

    }); 
  }, 
  getSuggestions: function(input, callback) {
    var regex = new RegExp('^' + input, 'i');
    var suggestions = patient.filter(function(p) {
      return regex.test(p);
    });

    callback(null, suggestions);
  },

  onSuggestionSelected: function(name, event) {
    event.preventDefault();
    console.log(name);
    this.setState({patientName: name, age: patientData[name].age, date: patientData[name].date, showPatient: true});
  },

  render: function() {
    return (
      <div>
        <Autosuggest suggestions={this.getSuggestions} inputAttributes={ {placeholder: "Search patient"} } onSuggestionSelected={this.onSuggestionSelected} />
        { this.state.showPatient ? <PatientBox patientName={this.state.patientName} age={this.state.age} date={this.state.date} /> : null }
      </div>
    )
  }

});

var PatientBox = React.createClass({
  render: function() {
    return (
      <div className="patientBox">
        <div className="row">
          <div className="col-md-5  toppad  pull-right col-md-offset-3 ">
          </div>
            <div className="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
              <div className="panel panel-info">
                <div className="panel-heading">
                  <h3 className="panel-title">{this.props.patientName}</h3>
                </div>
                <div className="panel-body">
                  <div className="row">
                    <div className="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="../img/jpg" className="img-circle img-responsive" /> </div>
                    <div className=" col-md-9 col-lg-9 ">
                      <table className="table table-user-information">
                        <tbody>
                          <tr>
                            <td>Age:</td>
                            <td>{this.props.age}</td>
                          </tr>
                          <tr>
                            <td>Date of Birth</td>
                            <td>{this.props.date}</td>
                          </tr>
                             <tr>
                                 <tr>
                            <td>Gender</td>
                            <td>Female</td>
                          </tr>
                            <tr>
                            <td>Home Address</td>
                            <td>Philadelphia</td>
                          </tr>
                          <tr>
                            <td>Email</td>
                            <td><a href="#">something@s.com</a></td>
                          </tr>
                            <td>Phone Number</td>
                            <td>123-4567-890(Landline)<br/><br/>555-4567-890(Mobile)
                            </td>

                          </tr>

                        </tbody>
                      </table>
                    </div>
                  </div>
                </div>
                <div class="panel-footer wide">
                    <span class="pull-right">
                        <a data-original-title="Remove this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-remove"></i></a>
                    </span>
                </div>
              </div>
            </div>
          </div>
        </div>
    );
  }
});

ReactDOM.render(
  <App />,
  document.getElementById('app')
);
