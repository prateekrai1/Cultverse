import './sidemenu.css'
export default function Sidemenu() {
  return (
    <div className='sidemenu'>
      <ul className='menu-items border-bottom'>
        <li><a href="https://sdf.com">Books</a></li>
        <li><a href="https://sdf.com">Tshirts</a></li>
        <li><a href="https://sdf.com">Sales</a></li>
        <li><a href="https://sdf.com">Pants</a></li>
      </ul>
      <div className='border-bottom padding-bottom'>
        <span>Gender</span>
        <form action="">
            <div className='form-control'><input type="checkbox" name="gender" id="" /><label htmlFor="male">Male</label></div>
            <div className="form-control"><input type="checkbox" name="gender" id="" /><label htmlFor="male">Female</label></div>
        </form>
      </div>
      <div style={{paddingTop:'2rem'}}>
        <span>Price</span>
        <form action="">
            <div className='form-control'><input type="checkbox" name="gender" id="" /><label htmlFor="male">$24 - $50</label></div>
            <div className="form-control"><input type="checkbox" name="gender" id="" /><label htmlFor="male">&lt; $24</label></div>
        </form>
      </div>
     
    </div>
  )
}
