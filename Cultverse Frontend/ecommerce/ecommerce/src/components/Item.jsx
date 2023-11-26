import './maincontent.css';
export default function Item({item}) {
  return (
    <div className='item'>
      <div className="img-container">
        <img src={item.item_image} alt="" />
      </div>
      <span>{item.item_name}</span>
      <span>{item.item_price}$</span>
    </div>
  )
}
